package com.annamorgiel.popular_movies.rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Anna Morgiel on 15.04.2017.
 */

public class RestClient {
    private static final String BASE_URL = "http://image.tmdb.org/t/p/";
    private MovieService apiService;

    public RestClient()
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(MovieService.class);
    }

    public MovieService getMovieService()
    {
        return apiService;
    }
}
