package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

//Class created by Erik and Louise
//This class represents the view of the choosing of subCategory, ex. Addition.
public class SubCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_subCategory);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kategori");

        //Added by Louise to be able to go back to SubjectActivity (The arrow in the right left corner).
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
}