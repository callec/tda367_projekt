package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.down_to_earth_rats.quiz_game.databinding.ActivityResultsBinding;
import android.widget.Button;

// Carl
public class resultsActivity extends AppCompatActivity {

    private ActivityResultsBinding viewBinding;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_results);
        viewBinding = ActivityResultsBinding.inflate(getLayoutInflater());

        // perhaps toolbar stuff here but disregarded for now
        // is it really necessary with two exit points?
    }

    public void backButtonPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}