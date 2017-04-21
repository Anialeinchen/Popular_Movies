package com.annamorgiel.popular_movies.rest.model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse implements Parcelable
{

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("results")
    @Expose
    private List<Movie> movies = null;
    @SerializedName("total_results")
    @Expose
    private int totalResults;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;
    public final static Parcelable.Creator<ApiResponse> CREATOR = new Creator<ApiResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ApiResponse createFromParcel(Parcel in) {
            ApiResponse instance = new ApiResponse();
            instance.page = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.movies, (com.annamorgiel.popular_movies.rest.model.Movie.class.getClassLoader()));
            instance.totalResults = ((int) in.readValue((int.class.getClassLoader())));
            instance.totalPages = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public ApiResponse[] newArray(int size) {
            return (new ApiResponse[size]);
        }

    }
            ;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeList(movies);
        dest.writeValue(totalResults);
        dest.writeValue(totalPages);
    }

    public int describeContents() {
        return 0;
    }

}