package com.annamorgiel.popular_movies.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.annamorgiel.popular_movies.R;
import com.annamorgiel.popular_movies.app.App;
import com.annamorgiel.popular_movies.rest.model.ApiResponse;
import com.annamorgiel.popular_movies.rest.model.Movie;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anna Morgiel on 13.04.2017.
 */

public class DetailActivity extends AppCompatActivity {
    Long clickedItemId = null;
    Long movieId = null;
    String BASE_POSTER_URL = "http://image.tmdb.org/t/p/w185//";
    ImageView poster_iv = (ImageView) findViewById(R.id.detail_poster_iv);
    Movie movie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            movieId = intentThatStartedThisActivity.getLongExtra("movieId", 1L);
        }
        fetchMovieDetails(clickedItemId);
        };

        private void fetchMovieDetails(final Long movieId){
            App.getRestClient().getMovieService().getMovieDetails(movieId, new Callback<ApiResponse>(){
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (!response.isSuccessful()) {
                    ApiResponse body = response.body();
                    String poster_path_endpoint = body.getMovies().get(0).getPosterPath();
                    //todo: how to get the response ?
                    Picasso.with(DetailActivity.this).load(BASE_POSTER_URL + poster_path_endpoint).into(poster_iv);
                    movie = body.
                }
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
}

