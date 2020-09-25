package com.down_to_earth_rats.quiz_game.Model;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 */

public interface IQuizModel {

    IQuestion getQuestion();

    void answerQuestion(boolean alternative);

    int getTotalQuestions();

    int getResult();

    void registerObserver(IModelObserver observer);

    void removeObserver(IModelObserver observer);



}
