package com.down_to_earth_rats.quiz_game.quiz_model.question_data;

import com.down_to_earth_rats.quiz_game.utility.ListIterator;
import com.down_to_earth_rats.quiz_game.utility.Tuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * <p>
 * This class represents a simple 4 alternative question.
 * 1 correct answer and 3 false.
 * Based on the IQuestion interface
 */

class FourAltQuestion implements IQuestion {

    private String questionText;

    private List<Tuple<String, Boolean>> alternativeList = new ArrayList<>();

    public FourAltQuestion(String questionText, String correctAlt,
                           String secondAlt, String thirdAlt, String fourthAlt) {

        this.questionText = questionText;
        alternativeList.add(new Tuple<>(correctAlt, true));
        alternativeList.add(new Tuple<>(secondAlt, false));
        alternativeList.add(new Tuple<>(thirdAlt, false));
        alternativeList.add(new Tuple<>(fourthAlt, false));
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public Iterator<Tuple<String, Boolean>> getAlternatives() {

        return new ListIterator<>(alternativeList);
    }


}
