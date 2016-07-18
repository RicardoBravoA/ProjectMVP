package com.rba.mvpproject.presenter;

import android.util.Log;

import com.rba.mvpproject.interactor.LogInInteractor;
import com.rba.mvpproject.interactor.callback.LoginCallback;
import com.rba.mvpproject.model.response.UserResponse;
import com.rba.mvpproject.ui.view.LoginView;

import java.util.HashMap;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class LoginPresenter implements LoginCallback {

    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(HashMap<String, String> data) {
        loginView.showLoading();
        LogInInteractor.login(data, this);
    }

    @Override
    public void onSuccess(Object object) {
        UserResponse userResponse = (UserResponse) object;
        loginView.hideLoading();
        loginView.next(userResponse);
    }

    @Override
    public void onError(Object object) {
        String value = (String) object;
        Log.i("x- onError", value);
        loginView.hideLoading();
    }
}
