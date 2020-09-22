package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayList;
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
    public List<String> getFalseAlternatives() {
        List<String> testList = new ArrayList<>();
        testList.add(secondAlt);
        testList.add(thirdAlt);
        testList.add(fourthAlt);

        return testList;
    }
}
