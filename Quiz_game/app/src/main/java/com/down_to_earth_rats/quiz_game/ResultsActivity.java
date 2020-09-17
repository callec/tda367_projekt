package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.down_to_earth_rats.quiz_game.databinding.ActivityResultsBinding;

import android.view.View;
import android.widget.Button;

// Carl
public class ResultsActivity extends AppCompatActivity {

    private ActivityResultsBinding viewBinding;
    private Button backButton;

    private int playerScore = 7;
    private int maxScore = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_results);
        viewBinding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        // perhaps toolbar stuff here but disregarded for now
        // is it really necessary with two exit points?
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Resultat");

        setupButtons();
        setupText();
    }

    private void setupButtons() {
        viewBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButtonPressed(view);
            }
        });
        viewBinding.retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retryButtonPressed(view);
            }
        });
        // target compitability 8? need to support android version >23 as minimum though
        /*viewBinding.retryButton.setOnClickListener((View v) -> {
            retryButtonPressed(v);
        });*/
    }

    private void setupText() {
        viewBinding.maxScoreTextView.setText(Integer.toString(this.maxScore));
        viewBinding.playerScoreTextView.setText(Integer.toString(this.playerScore));
    }

    private void backButtonPressed(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void retryButtonPressed(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}