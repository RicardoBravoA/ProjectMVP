package com.rba.mvpproject.interactor.api;

import com.rba.mvpproject.model.response.UserResponse;
import com.rba.mvpproject.util.Constant;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public interface UserApi {

    @GET(Constant.URL_USER)
    void getUsers(Callback<UserResponse> callback);

    @GET(Constant.URL_USER_ADD)
    void addUser(@FieldMap Map<String, String> data, Callback<UserResponse> callback);

    @GET(Constant.URL_USER_LOGIN)
    void login(@FieldMap Map<String, String> data, Callback<UserResponse> callback);

}
