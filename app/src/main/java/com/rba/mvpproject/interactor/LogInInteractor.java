package com.rba.mvpproject.interactor;

import com.rba.mvpproject.interactor.api.UserApiManager;
import com.rba.mvpproject.interactor.callback.LoginCallback;
import com.rba.mvpproject.model.response.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class LogInInteractor {

    public static void login(Map<String, String> data, final LoginCallback callback) {

        UserApiManager.apiManager().login(data, new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }else{
                    callback.onError(null);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });

    }

}
