package com.down_to_earth_rats.quiz_game.Model.QuestionHandler;

import com.down_to_earth_rats.quiz_game.Model.IQuestion;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * This interface is the gateway receive information from the model.
 * Get questions and answer them, get result and total amount of questions.
 */

public interface IQuizModel {
    /**
     *
     * @return Returns the current question
     */
    IQuestion getQuestion();

    /**
     * Answers the current question
     */
    void nextQuestion();

    void registerObserver(IModelObserver observer);

    void removeObserver(IModelObserver observer);



}
