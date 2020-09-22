package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayList;
import java.util.List;

class FourAltQuestion {

    private String correctAlt;
    private String secondAlt;
    private String thirdAlt;
    private String fourthAlt;


    List<String> getAllAlternatives(){
        List<String> testList = new ArrayList<>();
        testList.add(getSecondAlt());
        testList.add(getThirdAlt());
        testList.add(getFourthAlt());

        return testList;
    }


    public String getCorrectAlt() {
        return correctAlt;
    }

    public void setCorrectAlt(String correctAlt) {
        this.correctAlt = correctAlt;
    }


    String getSecondAlt() {
        return secondAlt;
    }

    public void setSecondAlt(String secondAlt) {
        this.secondAlt = secondAlt;
    }

    String getThirdAlt() {
        return thirdAlt;
    }

    public void setThirdAlt(String thirdAlt) {
        this.thirdAlt = thirdAlt;
    }

    String getFourthAlt() {
        return fourthAlt;
    }

    public void setFourthAlt(String fourthAlt) {
        this.fourthAlt = fourthAlt;
    }
}
