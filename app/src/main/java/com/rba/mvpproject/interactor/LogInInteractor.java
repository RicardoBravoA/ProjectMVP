package com.rba.mvpproject.interactor;

import android.util.Log;

import com.rba.mvpproject.interactor.api.UserApiManager;
import com.rba.mvpproject.interactor.callback.LoginCallback;
import com.rba.mvpproject.model.response.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class LogInInteractor {

    public static void login(Map<String, String> data, final LoginCallback callback) {

        Log.i("x- data", data.toString());

        Call<LoginResponse> call = UserApiManager.apiManager().login(data);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(call, response.body());
                }else{
                    callback.onError(call, null);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onError(call, t.getMessage());
            }
        });

    }

}
