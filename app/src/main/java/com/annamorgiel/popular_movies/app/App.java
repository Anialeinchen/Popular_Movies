package com.annamorgiel.popular_movies.app;

import android.app.Application;

import com.annamorgiel.popular_movies.rest.RestClient;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */

public class App extends Application {
    private static RestClient restClient;

    @Override
    public void onCreate()
    {
        super.onCreate();

        restClient = new RestClient();
    }

    public static RestClient getRestClient()
    {
        return restClient;
    }

}
