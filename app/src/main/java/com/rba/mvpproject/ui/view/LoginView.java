package com.rba.mvpproject.ui.view;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public interface LoginView {

    void showLoading();
    void hideLoading();
    void next();
    void validSession();
    void showError(String error);

}
