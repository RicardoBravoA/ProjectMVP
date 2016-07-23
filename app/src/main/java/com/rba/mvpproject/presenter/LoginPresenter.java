package com.rba.mvpproject.presenter;

import android.util.Log;

import com.rba.mvpproject.R;
import com.rba.mvpproject.app.MVPProjectApplication;
import com.rba.mvpproject.interactor.LogInInteractor;
import com.rba.mvpproject.interactor.callback.LoginCallback;
import com.rba.mvpproject.model.response.LoginResponse;
import com.rba.mvpproject.storage.session.SessionManager;
import com.rba.mvpproject.ui.view.LoginView;
import com.rba.mvpproject.util.Constant;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class LoginPresenter implements LoginCallback {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(Map<String, String> data) {
        loginView.showLoading();
        LogInInteractor.login(data, this);
    }

    @Override
    public void onSuccess(Call call, Object o) {
        LoginResponse loginResponse = (LoginResponse) o;

        if(loginResponse.get_meta().getStatus().equals(Constant.KEY_SUCCESS)){
            SessionManager.addSession(MVPProjectApplication.getAppContext(),
                    loginResponse.getData().get(0));
            loginView.hideLoading();
            loginView.next();
        }else{
            loginView.showError(MVPProjectApplication.getAppContext().getString(R.string.message_login));
        }


    }

    @Override
    public void onError(Call call, String error) {
        if(!call.isCanceled() && error!=null){
            Log.i("x- onError", error);
            loginView.hideLoading();
        }
    }

}
