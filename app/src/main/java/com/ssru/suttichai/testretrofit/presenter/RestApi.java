package com.ssru.suttichai.testretrofit.presenter;

import com.ssru.suttichai.testretrofit.model.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Suttichai on 4/18/2016.
 */
public interface RestApi {

    @GET("/data/2.5/weather?q=Bangkok,th&appid=539c9a21d9321c61339d20d6fb850cbc")
    Call<Model> getWheatherReport();
}
