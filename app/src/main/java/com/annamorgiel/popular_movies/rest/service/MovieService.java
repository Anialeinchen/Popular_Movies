package com.annamorgiel.popular_movies.rest.service;

import com.annamorgiel.popular_movies.rest.model.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */
public interface MovieService {
    String BASE_URL = "http://api.themoviedb.org/3";

    //public void getPopularMovies(@Path("id") Integer id, @Query("q") String name, Callback<ApiResponse> callback);
    //request data from the endpoints /movie/popular?api_key=
    @GET("/movie/{sortby}?api_key={apkiKey}")
    Call<ApiResponse> getMovies(@Path("sortby") String sortby, @Path("apiKey") String apiKey, Callback<ApiResponse> callback);
/*
    @GET("/{id}/movie/top_rated")
    public void getPopularMovies(@Path("id") Integer id, @Query("q") String name, Callback<ApiResponse> callback);
*/
}
