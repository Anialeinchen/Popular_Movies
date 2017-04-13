package com.annamorgiel.popular_movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Anna Morgiel on 13.04.2017.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String textEntered = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
        //todo perform network request as async task
        }
    }
}
