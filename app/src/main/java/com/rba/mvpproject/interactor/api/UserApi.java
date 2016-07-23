package com.rba.mvpproject.interactor.api;

import com.rba.mvpproject.model.response.LoginResponse;
import com.rba.mvpproject.util.Constant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public interface UserApi {

    /*
    @GET(Constant.URL_USER)
    void getUsers(Callback<UserResponse> callback);

    @GET(Constant.URL_USER_ADD)
    void addUser(@FieldMap Map<String, String> data, Callback<UserResponse> callback);
    */
    @FormUrlEncoded
    @POST(Constant.URL_USER_LOGIN)
    Call<LoginResponse> login(@FieldMap Map<String, String> data);
}

