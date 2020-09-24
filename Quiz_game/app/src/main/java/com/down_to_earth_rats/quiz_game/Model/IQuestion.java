package com.down_to_earth_rats.quiz_game.Model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 * Interface representing the structure of a multiple alternative question
 * Only one alternative can be correct, the rest must be false
 */

public interface IQuestion {

    String getQuestionText();

    Iterator<Tuple<String, Boolean>> getAlternatives();

}
