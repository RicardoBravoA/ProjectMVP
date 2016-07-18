package com.rba.mvpproject.presenter;

import com.rba.mvpproject.interactor.LogInInteractor;
import com.rba.mvpproject.interactor.callback.LoginCallback;
import com.rba.mvpproject.ui.view.LoginView;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class LoginPresenter implements LoginCallback {

    LoginView loginView;
    LogInInteractor logInInteractor;

    public LoginPresenter(LoginView loginView, LogInInteractor logInInteractor) {
        this.loginView = loginView;
        this.logInInteractor = logInInteractor;
    }

    @Override
    public void onSuccess(Object object) {

    }

    @Override
    public void onError(Object object) {

    }
}
