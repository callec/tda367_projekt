package com.down_to_earth_rats.quiz_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        viewBinding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });

        setContentView(viewBinding.getRoot());

    }

    private void startQuiz(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}