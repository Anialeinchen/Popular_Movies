package com.annamorgiel.popular_movies.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.annamorgiel.popular_movies.R;

/**
 * Created by Anna Morgiel on 13.04.2017.
 */

public class DetailActivity extends AppCompatActivity {
    Long clickedItemId = null;
    Long movieId = null;
    String BASE_POSTER_URL = "http://image.tmdb.org/t/p/w185//";
    ImageView poster_iv = (ImageView) findViewById(R.id.detail_poster_iv);
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            movieId = intentThatStartedThisActivity.getLongExtra("movieId", 1L);
        App.getRestClient().getMovieService().getMovies(clickedItemId, new Callback<ApiResponse>()
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (!response.isSuccessful()) {
                    ApiResponse body = response.body();
                    String poster_path_endpoint = body.getMovies().get(0).getPosterPath();
                    Picasso.with(context).load(POSTER_PATH + poster_path_endpoint).into(movieposter);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
}*/
    }
