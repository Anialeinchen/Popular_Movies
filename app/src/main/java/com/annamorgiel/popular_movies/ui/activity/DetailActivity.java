package com.annamorgiel.popular_movies.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.annamorgiel.popular_movies.R;
import com.annamorgiel.popular_movies.app.App;
import com.annamorgiel.popular_movies.rest.model.ApiResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Anna Morgiel on 13.04.2017.
 */

public class DetailActivity extends AppCompatActivity {
    Integer clickedItemId = null;
    String BASE_POSTER_URL = "http://image.tmdb.org/t/p/w185//";
    ImageView poster_iv = (ImageView) findViewById(R.id.detail_poster_iv);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String clickedItemIndex = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
        //todo perform network request as async task
        //clickedItemId = clickedItemIndex.getId?
            //todo dummy id
        clickedItemId = 22;
        App.getRestClient().getMovieService().getMovies(clickedItemId, new Callback<ApiResponse>()
        {
           /* @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (!response.isSuccessful())
                {
                    //String poster_path_endpoint_detail  = response.body().getMovies();
                    //Picasso.with(DetailActivity.this).load(BASE_POSTER_URL + ).into(poster_iv);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e(getLocalClassName(), "Error : " + t.getMessage());
            }
        });
        }
    }
}
