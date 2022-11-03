package com.myapplication.Instance;

import retrofit2.Retrofit;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.1.159:4000/api/";

    public static ApiInterface getAPIService() {

        return ApiClientInstance.getRetrofitData(BASE_URL).create(ApiInterface.class);
    }
}
