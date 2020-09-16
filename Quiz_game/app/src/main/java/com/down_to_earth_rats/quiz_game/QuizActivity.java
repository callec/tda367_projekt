package com.down_to_earth_rats.quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


// Henrik, Sara, Carl
//
public class QuizActivity extends AppCompatActivity implements View.OnClickListener {


    Button a1;
    Button a2;
    Button a3;
    Button a4;

    TextView q;

    String correctAnswer;

    boolean wasCorrectChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setup();
    }

    private void setup(){
        a1 = findViewById(R.id.answerButton1);
        a2 = findViewById(R.id.answerButton2);
        a3 = findViewById(R.id.answerButton3);
        a4 = findViewById(R.id.answerButton4);
        q = findViewById(R.id.questionText);

        update();
    }

    void update(){

        wasCorrectChoice = false;

        q.setText("Hur mycket är 8,00 - 4,73?");

        a1.setText("4,73");
        a2.setText("4,37");
        a3.setText("3,37");
        a4.setText("3,27");

        correctAnswer = "3,27";
    }

    @Override
    public void onClick(View view){


        switch (view.getId()){
            case R.id.answerButton1:
            case R.id.answerButton2:
            case R.id.answerButton3:
            case R.id.answerButton4:

                Button b = (Button)view;

                if (b.getText().equals(correctAnswer)) {
                    wasCorrectChoice = true;
                    correctChoice(b);
                } else{
                    //TODO remove maybe?
                    b.setBackgroundColor(0xFFFF0000);
                }
                break;
        }
    }

    //TODO ADD WHAT SHOULD HAPPEN WHEN CORRECT CHOICE
    private void correctChoice(Button b){
        b.setBackgroundColor(0xFF00FF00);
    }

}