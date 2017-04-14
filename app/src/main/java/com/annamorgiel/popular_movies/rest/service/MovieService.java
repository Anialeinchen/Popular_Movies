package com.annamorgiel.popular_movies.rest.service;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */
public interface MovieService {

    //request data from the endpoints
    @GET("/movie/popular")
    public void getPopularMovies(@Query("q") String name, Callback<ApiResponse> callback);

    @GET("/movie/top_rated")
    public void getPopularMovies(@Query("q") String name, Callback<ApiResponse> callback);
}
