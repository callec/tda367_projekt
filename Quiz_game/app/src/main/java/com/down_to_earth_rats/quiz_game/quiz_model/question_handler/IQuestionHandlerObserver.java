package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * <p>
 * Receive a notification when no more questions are available to fetch.
 */

public interface IQuestionHandlerObserver {

    void quizFinished();

}
