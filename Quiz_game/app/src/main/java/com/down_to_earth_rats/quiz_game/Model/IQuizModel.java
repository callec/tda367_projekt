package com.down_to_earth_rats.quiz_game.Model;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 */

public interface IQuizModel {

    void insertQuestions(Iterator<IQuestion> questions);

    IQuestion getQuestion();

}
