package com.ssru.suttichai.testretrofit.presenter;

import com.ssru.suttichai.testretrofit.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Suttichai on 4/18/2016.
 */
public interface RestInterface {

    @GET("/weather?q=London,uk")
    Call<List<Model>> faculties();
}
