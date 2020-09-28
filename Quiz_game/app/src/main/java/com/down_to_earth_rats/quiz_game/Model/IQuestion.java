package com.down_to_earth_rats.quiz_game.Model;

import com.down_to_earth_rats.quiz_game.Model.Utility.Tuple;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * Interface representing the structure of a multiple alternative question
 * with a proposition (questionText)
 *
 * Each alternative are stored in a Tuple, which consist of a String (a text component)
 * and an Boolean to determine if the alternative is either true or false.
 */

public interface IQuestion {

    String getQuestionText();

    Iterator<Tuple<String, Boolean>> getAlternatives();

}
