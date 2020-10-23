package com.down_to_earth_rats.quiz_game.gui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityResultsBinding;

/**
 * Created by Carl
 * Modified by Sara
 * <p>
 * This class displays the results from previously answered quiz.
 */
public class ResultsActivity extends AppCompatActivity {

    private ActivityResultsBinding viewBinding;

    private Resources res;
    private SharedPreferences pref;

    private int playerScore;
    private int maxScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        pref = this.getSharedPreferences(String.valueOf(R.string.preferences_name), MODE_PRIVATE);

        viewBinding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        playerScore = getIntent().getIntExtra("Result", 0);
        maxScore = getIntent().getIntExtra("TotalQuestions", 0);

        Toolbar toolbar = viewBinding.resultToolbar;
        toolbar.setTitle("Resultat");
        setSupportActionBar(toolbar);

        setupButtons();
        setupText();
        checkHintUsed(findViewById(android.R.id.content).getRootView());
    }

    private void checkHintUsed(View view) {
        boolean hintsUsed = pref.getBoolean("hintsUsed", false);
        viewBinding.HintsUsed.setVisibility(hintsUsed ? view.VISIBLE : view.INVISIBLE);

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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}