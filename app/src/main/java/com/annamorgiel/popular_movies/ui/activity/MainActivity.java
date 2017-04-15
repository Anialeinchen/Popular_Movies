package com.annamorgiel.popular_movies.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.annamorgiel.popular_movies.MovieAdapter;
import com.annamorgiel.popular_movies.R;

public class MainActivity extends AppCompatActivity implements MovieAdapter.GridItemClickListener {

    private static final int NUM_GRID_ITEM = 100;
    private MovieAdapter mAdapter;
    private RecyclerView mMoviesGrid;
    Context context = MainActivity.this;
    Class detailActivity = DetailActivity.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMoviesGrid = (RecyclerView) findViewById(R.id.rv_movies);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mMoviesGrid.setLayoutManager(layoutManager);
        //mMoviesGrid.hasFixedSize(true);
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
        Intent startChildActivityIntent = new Intent(context, detailActivity);
        startChildActivityIntent.putExtra(Intent.EXTRA_TEXT, clickedItemIndex);
        startActivity(startChildActivityIntent);
    }
}
