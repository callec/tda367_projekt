package com.down_to_earth_rats.quiz_game;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.down_to_earth_rats.quiz_game.databinding.ActivitySubCategoryBinding;

//Class created by Erik and Louise
//This class represents the view of the choosing of subCategory, ex. Addition.
public class SubCategoryActivity extends AppCompatActivity {

    private ActivitySubCategoryBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivitySubCategoryBinding.inflate(getLayoutInflater());

        //Configure toolbar
        Toolbar toolbar = viewBinding.toolbarSubCategory;
        toolbar.setTitle(R.string.category_title);
        setSupportActionBar(toolbar);

        //Added by Louise to be able to go back to SubjectActivity (The arrow in the right left corner).
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        setContentView(viewBinding.getRoot());

    }
}