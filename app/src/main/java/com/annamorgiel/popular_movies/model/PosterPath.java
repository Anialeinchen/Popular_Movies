package com.annamorgiel.popular_movies.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import java.io.Serializable;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */
@Parcel
public class PosterPath {
    @SerializedName("poster_path")
    private String poster_path;

    public String getPosterPath(){return posterPath;}
    public void setPosterPath(String posterPath){ this.poster_path = posterPath;}
}
