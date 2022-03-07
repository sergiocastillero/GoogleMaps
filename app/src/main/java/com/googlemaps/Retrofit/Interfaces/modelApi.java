package com.googlemaps.Retrofit.Interfaces;

import com.googlemaps.Retrofit.Models.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface modelApi {

    @GET("?method=flickr.photos.search&api_key=79d466885188b99d6762980d64029892&format=json&nojsoncallback=1")
    Call<Model> getData(@Query("lat") double lat,@Query("lon") double lon );
}
