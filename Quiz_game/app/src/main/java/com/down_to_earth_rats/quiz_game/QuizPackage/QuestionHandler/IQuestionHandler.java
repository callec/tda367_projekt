package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * Interface responsible for providing questions.
 * Observers will receive notification when no more questions are left.
 */

public interface IQuestionHandler {
    /**
     * If no more question are available, it will notify all observers.
     * @return Returns the current question
     */
    IQuestion getQuestion();

    /**
     * Advance to the next question.
     * If no more question are available, it will notify all observers.
     */
    void nextQuestion();

    /**
     *
     * @return true if only one question remains, else false.
     */
    boolean isLastQuestion();

    void registerObserver(IQuestionHandlerObserver observer);

    void removeObserver(IQuestionHandlerObserver observer);



}
