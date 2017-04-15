package com.annamorgiel.popular_movies.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */
@Parcel
public class PosterPath {
    @SerializedName("poster_path")
    private String posterPath;

    public String getPosterPath(){return posterPath;}
    public void setPosterPath(String posterPath){ this.posterPath = posterPath;}
}
