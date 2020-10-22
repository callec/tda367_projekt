package com.down_to_earth_rats.quiz_game.quiz_model.question_data;

import com.down_to_earth_rats.quiz_game.utility.Tuple;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * Interface representing the structure of a multiple alternative question
 *
 */

public interface IQuestion {

    /**
     *
     * @return
     */
    String getQuestionText();

    /**
     * Each alternative are stored in a Tuple, which consist of a String (a text component)
     * and an Boolean to determine if the alternative is either true or false.
     * @return A collection of alternatives
     */
    Iterator<Tuple<String, Boolean>> getAlternatives();

}
