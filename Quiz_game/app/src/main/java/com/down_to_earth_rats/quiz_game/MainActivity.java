package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.down_to_earth_rats.quiz_game.Model.IQuizModel;
import com.down_to_earth_rats.quiz_game.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

//This class will be our start screen later
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinder = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinder.getRoot());

        viewBinder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoResult(view);
            }
        });


    }

    public void gotoResult(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}
