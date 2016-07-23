package com.rba.mvpproject.interactor.callback;

import retrofit2.Call;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public interface LoginCallback<T> {

    void onSuccess(Call<T> call, T t);
    void onError(Call<T> call, String error);
}
