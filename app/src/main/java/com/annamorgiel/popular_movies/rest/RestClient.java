package com.annamorgiel.popular_movies.rest;

import com.annamorgiel.popular_movies.rest.service.MovieService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Anna Morgiel on 15.04.2017.
 */
//todo add api key add sortby add restclient
public class RestClient {
    private static final String BASE_URL = "http://api.themoviedb.org/3";
    private MovieService apiService;


    public RestClient(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(MovieService.class);
    }

    public MovieService getMovieService()
    {
        return apiService;
    }
}
