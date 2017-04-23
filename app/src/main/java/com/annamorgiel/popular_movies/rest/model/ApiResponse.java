package com.annamorgiel.popular_movies.rest.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Anna Morgiel on 14.04.2017.
 */

@Parcel
public class ApiResponse {

        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("movies")
        @Expose
        private List<MovieObject> movies = null;
        @SerializedName("total_results")
        @Expose
        private Integer totalResults;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public List<MovieObject> getMovies() {
            return movies;
        }

        public void setMovies(List<MovieObject> movies) {
            this.movies = movies;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

    }