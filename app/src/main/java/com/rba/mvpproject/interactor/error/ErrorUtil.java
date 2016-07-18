package com.rba.mvpproject.interactor.error;

import com.rba.mvpproject.interactor.api.UserApiManager;
import com.rba.mvpproject.model.response.ErrorResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 17/07/16.
 */

public class ErrorUtil {

    public static ErrorResponse parseError(Response<?> response) {

        Converter<ResponseBody, ErrorResponse> converter = UserApiManager.getRetrofit()
                .responseBodyConverter(ErrorResponse.class,
                        new Annotation[0]);

        ErrorResponse error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ErrorResponse();
        }

        return error;
    }

}
