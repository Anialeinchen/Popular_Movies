package com.annamorgiel.popular_movies.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

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
    private MovieAdapter mAdapter;
    private RecyclerView mMoviesGrid;
    private String defaultSortBy = "popular";
    private String POSTER_PATH = "http://image.tmdb.org/t/p/w185//";
    String apiKey = THE_MOVIE_DB_API_KEY;
    Context context = MainActivity.this;
    private ImageView movieposter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMoviesGrid = (RecyclerView) findViewById(R.id.rv_movies);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mMoviesGrid.setLayoutManager(layoutManager);
        //mMoviesGrid.hasFixedSize(true);
        movieposter = (ImageView) findViewById(R.id.poster_iv);
        App.getRestClient().getMovieService().getMovies(defaultSortBy, apiKey, new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (!response.isSuccessful())
                {
                    ApiResponse body = response.body();
                    String poster_path_endpoint = body.getMovies().get(0).getPosterPath();
                    Picasso.with(context).load(POSTER_PATH + poster_path_endpoint).into(movieposter);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
        mAdapter = new MovieAdapter(NUM_GRID_ITEM, this);
        mMoviesGrid.setAdapter(mAdapter);
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
        switch (id){
            case R.id.sort_by_popularity:
                mAdapter = new MovieAdapter(NUM_GRID_ITEM,this);
                mMoviesGrid.setAdapter(mAdapter);
                return true;

            case R.id.sort_by_ranking:
                mAdapter = new MovieAdapter(NUM_GRID_ITEM,this);
                mMoviesGrid.setAdapter(mAdapter);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGridItemClick(int clickedItemIndex) {
        //Intent startChildActivityIntent = new Intent(context, DetailActivity.class);
        //todo to string??
        //startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, clickedItemIndex);
        //startActivity(startChildActivityIntent);
    }
}
