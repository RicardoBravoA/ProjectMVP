package com.rba.mvpproject.ui.view;

import com.rba.mvpproject.model.response.UserResponse;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public interface LoginView {

    void showLoading();
    void hideLoading();
    void next(UserResponse userResponse);

}
