package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 *
 * This class represents a simple 4 alternative question.
 * 1 correct answer and 3 false.
 * Based on the IQuestion interface
 */

class FourAltQuestion implements IQuestion {

    private String questionText;

    private String correctAlt;
    private String secondAlt;  //Maybe: "wrongAlt1"
    private String thirdAlt;
    private String fourthAlt;

    public FourAltQuestion(String questionText, String correctAlt,
                           String secondAlt, String thirdAlt, String fourthAlt) {

        this.questionText = questionText;
        this.correctAlt = correctAlt;
        this.secondAlt = secondAlt;
        this.thirdAlt = thirdAlt;
        this.fourthAlt = fourthAlt;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public String getCorrectAlternative() {
        return correctAlt;
    }

    @Override
    public Iterator<String> getFalseAlternatives() {
        List<String> list = new ArrayList<>();
        list.add(secondAlt);
        list.add(thirdAlt);
        list.add(fourthAlt);

        return new ListIterator<>(list);
    }
}
