package com.down_to_earth_rats.quiz_game;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.down_to_earth_rats.quiz_game.Model.QuizActivityViewModel;
import com.down_to_earth_rats.quiz_game.databinding.ActivityQuizBinding;

import java.util.List;


// Henrik, Sara, Carl, Erik, Louise

// TODO:
//  - how to handle alternatives from viewmodel
//  - how to update with new question_textview
public class QuizActivity extends AppCompatActivity implements IModalFragmentHandler {

    private ActivityQuizBinding viewBinding;

    String correctAnswer;
    boolean wasCorrectChoice;
    modalFragment modal;
    QuizActivityViewModel model;
    private Button alternative1;
    private Button alternative2;
    private Button alternative3;
    private Button alternative4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(QuizActivityViewModel.class);

        viewBinding = ActivityQuizBinding.inflate(getLayoutInflater());

        handleSupportActionBar();
        //update();

        setContentView(viewBinding.getRoot());

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

    private void handleSupportActionBar() {

        Toolbar toolbar = viewBinding.toolbarQuiz;
        toolbar.setTitle(R.string.math_subject);

        setSupportActionBar(toolbar);

        // TODO: ask the user to make sure he wants to end the quiz and go back
        //sb.setDisplayHomeAsUpEnabled(true);
    }


    /*
    void update() {

        wasCorrectChoice = false;

        viewBinding.questionText.setText("Hur mycket är 8,00 - 4,73?");

        viewBinding.answerButton1.setText("4,73");
        viewBinding.answerButton2.setText("4,37");
        viewBinding.answerButton3.setText("3,37");
        viewBinding.answerButton4.setText("3,27");

        correctAnswer = "3,27";
    }

     */


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

                /*
                Button b = (Button) view;

                // TODO: this case
                // want to add hint button later, guess() would reduce clutter
                grayOutButtons();
                if (b.getText().equals(correctAnswer)) {
                    //wasCorrectChoice = true;
                    //correctChoice(b);
                    //guess(true, view);
                    b.setBackgroundResource(R.drawable.correct_button);
                } else {
                    //b.setBackgroundColor(0xFFFF0000);
                    //guess(false, view);
                    b.setBackgroundResource(R.drawable.wrong_button);
                }

                CountDown();

                 */

                break;
        }
        guess(model.answerQuestion(id),view);
        CountDown();
    }

    private void switchActivityToResult() {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    private void switchActivityToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Count down to next question
    private void CountDown() {
        viewBinding.progressBar.setVisibility(View.VISIBLE);

        new CountDownTimer(3000, 30) {

            @Override
            public void onTick(long l) {
                viewBinding.questionText.setText("Resultat om: " + ((l / 1000) + 1));
                viewBinding.progressBar.incrementProgressBy(1);

            }


            @Override
            public void onFinish() {
                //model.changeQuestion();
                finish();
                startActivity(getIntent());
            }



        }.start();
    }


    //TODO ADD WHAT SHOULD HAPPEN WHEN CORRECT CHOICE
    private void correctChoice(Button b) {
        //b.setBackgroundColor(0xFF00FF00);
        b.setBackgroundResource(R.drawable.correct_button);
    }

    private void grayOutButtons() {
        // why not use attributes? might use the buttons again
        Button[] blist = {viewBinding.answerButton1,
                viewBinding.answerButton2,
                viewBinding.answerButton3,
                viewBinding.answerButton4};
        for (Button b : blist) {
            b.setClickable(false);
            b.setBackgroundResource(R.drawable.grey_button);
        }
    }

    private void guess(boolean guess, View v) {
        grayOutButtons();
        if (guess) {
            v.setBackgroundResource(R.drawable.correct_button);
        } else {
            v.setBackgroundResource(R.drawable.wrong_button);
            // TODO: find correct button and set correct_grey_button
        }
    }

    //Consume back press
    @Override
    public void onBackPressed() {
        modal = new modalFragment(this.getResources().getString(R.string.quit_quiz_modal), this.getResources().getStringArray(R.array.quit_quiz_modal), this);
        modal.show(this.getSupportFragmentManager(), "s");
        //modal.setCancelable(false);
    }

    //Decide what to do depending on what button was pressed (called from modalFragment)
    @Override
    public void modalFragmentButtonPressed(int buttonIndex) {
        switch (buttonIndex) {
            //"Continue"
            case 0:
                break;
            //"Restart"
            case 1:
                //TODO restart quiz
                break;
            //"Quit"
            case 2:
                //TODO go to result or straight to menu?
                switchActivityToMenu();
        }
    }
}