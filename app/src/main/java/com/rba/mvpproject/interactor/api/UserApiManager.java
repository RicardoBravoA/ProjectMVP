package com.rba.mvpproject.interactor.api;

import com.rba.mvpproject.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class UserApiManager {

    private static UserApi userApi ;

    public static UserApi apiManager() {

        if(userApi == null){

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();


            Retrofit client = new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOST)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            userApi = client.create(UserApi.class);
        }

        return userApi;
    }

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return client;
    }

}
