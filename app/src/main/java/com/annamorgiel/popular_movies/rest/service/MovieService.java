package com.annamorgiel.popular_movies.rest.service;

import com.annamorgiel.popular_movies.rest.model.ApiResponse;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */
public interface MovieService {

    //public void getPopularMovies(@Path("id") Integer id, @Query("q") String name, Callback<ApiResponse> callback);
    //request data from the endpoints
    @GET("/{id}/movie/{sortby}")
    public void getPopularMovies(@Path("id") Integer id, @Query("sortby") String sortby, Callback<ApiResponse> callback);
/*
    @GET("/{id}/movie/top_rated")
    public void getPopularMovies(@Path("id") Integer id, @Query("q") String name, Callback<ApiResponse> callback);
*/
}
