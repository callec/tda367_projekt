package com.down_to_earth_rats.quiz_game.Model;

import java.util.Iterator;

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
     * @param alternative the statement associated with an alternative
     */
    void answerQuestion(boolean alternative);

    /**
     *
     * @return total amount of questions
     */
    int getTotalQuestions();


    /**
     *
     * @return the amount of correct answers
     */
    int getResult();

    void registerObserver(IModelObserver observer);

    void removeObserver(IModelObserver observer);



}
