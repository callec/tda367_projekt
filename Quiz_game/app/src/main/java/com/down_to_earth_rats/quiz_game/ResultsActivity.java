package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.down_to_earth_rats.quiz_game.databinding.ActivityResultsBinding;

import android.view.View;
import android.widget.Button;

/**
 * Created by Carl
 */
public class ResultsActivity extends AppCompatActivity {

    private ActivityResultsBinding viewBinding;
    private Button backButton;

    private int playerScore;
    private int maxScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        playerScore = getIntent().getIntExtra("Result", 0);
        maxScore = getIntent().getIntExtra("PlayerScore", 0);

        // perhaps toolbar stuff here but disregarded for now
        // is it really necessary with two exit points?
        Toolbar toolbar = viewBinding.resultToolbar;
        toolbar.setTitle("Resultat");
        setSupportActionBar(toolbar);

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
        onBackPressed();
    }

    private void retryButtonPressed(View view) {
        startActivity(new Intent(this, QuizActivity.class));
    }

    //Change
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}