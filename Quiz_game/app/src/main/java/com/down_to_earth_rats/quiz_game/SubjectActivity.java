package com.down_to_earth_rats.quiz_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.down_to_earth_rats.quiz_game.databinding.ActivitySubjectBinding;

//Class created by Erik and Louise.
//This class represents the view of the choosing of Subject, ex. Math.
public class SubjectActivity extends AppCompatActivity {

    private ActivitySubjectBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivitySubjectBinding.inflate(getLayoutInflater());

        Toolbar toolbar = viewBinding.toolbarSubject;
        toolbar.setTitle(R.string.subject_title);
        setSupportActionBar(toolbar);

        //Button onClick
        viewBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathButtonPressed(view);
            }
        });

        setContentView(viewBinding.getRoot());
    }

    //Navigate to category activity
    public void mathButtonPressed(View view){
        Intent intent = new Intent(this, SubCategoryActivity.class);
        startActivity(intent);
    }
}
