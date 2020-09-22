package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FourAltQuestion implements IQuestion {

    private String correctAlt;
    private String secondAlt;
    private String thirdAlt;
    private String fourthAlt;

    public FourAltQuestion(String correctAlt, String secondAlt, String thirdAlt, String fourthAlt) {
        this.correctAlt = correctAlt;
        this.secondAlt = secondAlt;
        this.thirdAlt = thirdAlt;
        this.fourthAlt = fourthAlt;
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
