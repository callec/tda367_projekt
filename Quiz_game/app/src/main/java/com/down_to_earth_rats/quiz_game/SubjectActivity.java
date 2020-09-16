package com.down_to_earth_rats.quiz_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//Class created by Erik and Louise.
//This class represents the view of the choosing of Subject, ex. Math.
public class SubjectActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_subject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ämne");

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SubCategoryActivity.class);
        startActivity(intent);
    }
}
