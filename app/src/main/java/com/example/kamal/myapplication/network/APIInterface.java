package com.example.kamal.myapplication.network;


import com.example.kamal.myapplication.model.pojo.Rss;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIInterface
{

    @GET("hubs/all")
    Call<Rss> getdata();
}
