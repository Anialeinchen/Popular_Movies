package com.annamorgiel.popular_movies.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.annamorgiel.popular_movies.MovieAdapter;
import com.annamorgiel.popular_movies.R;
import com.annamorgiel.popular_movies.app.App;
import com.annamorgiel.popular_movies.rest.model.ApiResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.annamorgiel.popular_movies.BuildConfig.THE_MOVIE_DB_API_KEY;

public class MainActivity extends AppCompatActivity implements MovieAdapter.GridItemClickListener {

    private static final int NUM_GRID_ITEM = 100;
    String apiKey = THE_MOVIE_DB_API_KEY;
    Context context = MainActivity.this;
    private MovieAdapter mAdapter;
    private RecyclerView mMoviesGrid;
    private String POSTER_PATH = "http://image.tmdb.org/t/p/w185/";
    private ImageView movieposter = null;
    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        mLoadingIndicator.setVisibility(View.VISIBLE);

        mMoviesGrid = (RecyclerView) findViewById(R.id.rv_movies);

        mErrorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mMoviesGrid.setLayoutManager(layoutManager);

        //mMoviesGrid.hasFixedSize(true);

        movieposter = (ImageView) findViewById(R.id.poster_iv);

        mAdapter = new MovieAdapter(NUM_GRID_ITEM, this);

        mMoviesGrid.setAdapter(mAdapter);

        String defaultSortBy = "popular";

        Call<ApiResponse> call = App.getRestClient().getMovieService().getMovies(defaultSortBy, apiKey);

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    mLoadingIndicator.setVisibility(View.INVISIBLE);
                    showMovieDataView();

                    ApiResponse body = response.body();
                    mAdapter.setMovieList(body.getMovies());
                    String poster_path_endpoint = body.getMovies().get(0).getPosterPath();
                    Picasso.with(context).load(POSTER_PATH + poster_path_endpoint).into(movieposter);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//todo add change by popularity, by ranking
        switch (id) {
            case R.id.sort_by_popularity:
                mAdapter = new MovieAdapter(NUM_GRID_ITEM, this);
                mMoviesGrid.setAdapter(mAdapter);
                return true;

            case R.id.sort_by_ranking:
                mAdapter = new MovieAdapter(NUM_GRID_ITEM, this);
                mMoviesGrid.setAdapter(mAdapter);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGridItemClick(int clickedItemIndex) {
        Class destinationClass = DetailActivity.class;
        Long clickedItemId = mAdapter.getItemId(clickedItemIndex);
        Intent intentToStartDetailActivity = new Intent(context, destinationClass);
        intentToStartDetailActivity.putExtra("movieId",clickedItemId);
        startActivity(intentToStartDetailActivity);
    }
    private void showMovieDataView() {
        /* First, make sure the error is invisible */
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        /* Then, make sure the weather data is visible */
        mMoviesGrid.setVisibility(View.VISIBLE);
    }
    private void showErrorMessage() {
        /* First, hide the currently visible data */
        mMoviesGrid.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

}