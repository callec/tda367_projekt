package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * This interface is the gateway receive information from the model.
 * Get questions and answer them, get result and total amount of questions.
 */

public interface IQuestionHandler {
    /**
     *
     * @return Returns the current question
     */
    IQuestion getQuestion();

    /**
     * Answers the current question
     */
    void nextQuestion();

    void registerObserver(IQuestionHandlerObserver observer);

    void removeObserver(IQuestionHandlerObserver observer);

    boolean isLastQuestion();

}
