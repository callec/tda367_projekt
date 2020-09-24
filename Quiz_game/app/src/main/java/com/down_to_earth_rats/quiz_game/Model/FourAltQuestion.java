package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 * This class represents a simple 4 alternative question.
 * 1 correct answer and 3 false.
 * Based on the IQuestion interface
 */

class FourAltQuestion implements IQuestion {

    private String questionText;

    private List<Tuple<Boolean, String>> alternativeList = new ArrayList<>();

    public FourAltQuestion(String questionText, String correctAlt,
                           String secondAlt, String thirdAlt, String fourthAlt) {

        this.questionText = questionText;
        alternativeList.add(new Tuple<>(true, correctAlt));
        alternativeList.add(new Tuple<>(false, secondAlt));
        alternativeList.add(new Tuple<>(false, thirdAlt));
        alternativeList.add(new Tuple<>(false, fourthAlt));
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public Iterator<Tuple<Boolean, String>> getAlternatives() {

        return new ListIterator<>(alternativeList);
    }


}
