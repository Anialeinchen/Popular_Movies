package com.annamorgiel.popular_movies.rest.model;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */

@Parcel
public class ApiResponse {
    @SerializedName("poster_path")
    private PosterPath posterPath;

    public PosterPath posterPath(){return posterPath;}
}
