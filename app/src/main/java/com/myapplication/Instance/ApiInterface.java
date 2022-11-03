package com.myapplication.Instance;

import com.myapplication.Model.ImageLiveData;
import com.myapplication.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("Crops")
    Call<List<ImageLiveData>> getAllPhotos();

    @Headers({"Content-type: application/json"})
    @POST("Authenticate/Login")
    Call<Post> sendPosts(@Body Post posts);
}
