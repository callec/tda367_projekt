package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * Receive a notification when no more questions are available to fetch.
 */

public interface IQuestionHandlerObserver {

    void quizFinished();

}
