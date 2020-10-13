package com.down_to_earth_rats.quiz_game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel.IViewModel;
import com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel.StandardQuizViewModel;
import com.down_to_earth_rats.quiz_game.databinding.ActivityQuizBinding;

import java.util.List;

/**
 * Created and edited by Henrik, Sara, Carl, Erik, Louise
 */
public class QuizActivity extends AppCompatActivity implements IModalFragmentHandler {

    private ActivityQuizBinding viewBinding;

    private int timerTextId;

    private modalFragment modal;
    private IViewModel model;

    private Resources res;
    private SharedPreferences pref;

    private Button alternative1;
    private Button alternative2;
    private Button alternative3;
    private Button alternative4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        res = getResources();
        pref = this.getSharedPreferences(String.valueOf(R.string.preferences_name), MODE_PRIVATE);

        model = new ViewModelProvider(this).get(StandardQuizViewModel.class);
        model.setTotalQuestions(pref.getInt("TotalQuestions", res.getInteger(R.integer.totalq_defaultvalue)));
        model.initQuiz();

        viewBinding = ActivityQuizBinding.inflate(getLayoutInflater());

        setContentView(viewBinding.getRoot());

        setupSupportActionBar();
        setupOnQuizEnd();
        setupTimerText();
        setupButtons();
    }

    private void setupOnQuizEnd() {
        model.getRunningState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean state) {
                if (!state) {
                    switchActivityToResult();
                }
            }
        });
    }

    private void setupTimerText() {
        timerTextId = R.string.nextq_in;

        model.getIsLast().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLastQuestion) {
                if (isLastQuestion) {
                    timerTextId = R.string.result_in;
                }
            }
        });
    }

    private void setupButtons() {
        alternative1 = viewBinding.answerButton1;
        alternative2 = viewBinding.answerButton2;
        alternative3 = viewBinding.answerButton3;
        alternative4 = viewBinding.answerButton4;

        model.getAlternativeList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                viewBinding.questionText.setText(strings.get(0));
                alternative1.setText(strings.get(1));
                alternative2.setText(strings.get(2));
                alternative3.setText(strings.get(3));
                alternative4.setText(strings.get(4));
            }
        });
    }

    private void setupSupportActionBar() {
        Toolbar toolbar = viewBinding.toolbarQuiz;
        toolbar.setTitle(R.string.math_subject);

        setSupportActionBar(toolbar);
    }


    public void clickAlternative(View view) {

        int id = 1;
        switch (view.getId()) {
            case R.id.answerButton1:
                id = 1;
                break;
            case R.id.answerButton2:
                id = 2;
                break;
            case R.id.answerButton3:
                id = 3;
                break;
            case R.id.answerButton4:
                id = 4;
                break;
        }
        guess(model.answerQuestion(id), view);
        CountDown();
    }

    private void switchActivityToResult() {
        Intent intent = new Intent(this, ResultsActivity.class);

        intent.putExtra("Result", model.getCorrectAnswers());
        intent.putExtra("TotalQuestions", model.getTotalQuestions());

        startActivity(intent);
    }

    private void switchActivityToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Count down to next question
    private void CountDown() {
        viewBinding.progressBar.setVisibility(View.VISIBLE);

        new CountDownTimer(1000, 10) {

            @Override
            public void onTick(long l) {
                //viewBinding.questionText.setText(getString(timerTextId, ((l / 1000) + 1)));
                viewBinding.progressBar.incrementProgressBy(2);
            }



            @Override
            public void onFinish() {
                disableProgressBar();
                enableButtons(true, alternative1, alternative2, alternative3, alternative4);
                model.changeQuestion();
            }

        }.start();
    }

    private void disableProgressBar() {
        viewBinding.progressBar.setVisibility(View.INVISIBLE);
        viewBinding.progressBar.setProgress(0);
    }

    private void enableButtons(boolean enable, Button... blist) {
        if (blist.length < 1) {
            throw new ArrayIndexOutOfBoundsException("No buttons in method call.");
        }
        for (Button b : blist) {
            b.setClickable(enable);
            if (!enable) {
                b.setBackgroundResource(R.drawable.grey_button);
            } else {
                b.setBackgroundResource(R.drawable.round_button);
            }
        }
    }

    private void guess(boolean guess, View v) {
        enableButtons(false, alternative1, alternative2, alternative3, alternative4);
        if (guess) {
            v.setBackgroundResource(R.drawable.correct_button);
        } else {
            v.setBackgroundResource(R.drawable.wrong_button);
            // TODO: find correct button and set correct_grey_button
        }
    }

    // Consume back press
    @Override
    public void onBackPressed() {
        modal = new modalFragment(this.getResources().getString(R.string.quit_quiz_modal), this.getResources().getStringArray(R.array.quit_quiz_modal), this);
        modal.show(this.getSupportFragmentManager(), "s");
    }

    // Decide what to do depending on what button was pressed (called from modalFragment)
    @Override
    public void modalFragmentButtonPressed(int buttonIndex) {
        switch (buttonIndex) {
            // "Continue"
            case 0:
                break;
            // "Restart"
            case 1:
                //TODO this works for quiz of mathematical types where the questions are generated
                model.initQuiz();
                break;
            // "Quit"
            case 2:
                switchActivityToMenu();
        }
    }
}