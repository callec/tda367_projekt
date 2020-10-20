package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 */

public class MockHandlerObserver implements IQuestionHandlerObserver {


    private boolean condition = false;

    @Override
    public void quizFinished() {
        condition = true;
    }

    public boolean isCondition() {
        return condition;
    }

}
