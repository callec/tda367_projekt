package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class FourAltQuestionTest {

    private FourAltQuestion question;

    private String correctAlt = "Correct";
    private String secondAlt = "Two";
    private String thirdAlt = "Third";
    private String fourthAlt = "Fourth";

    @Before
    public void initialize(){
        question = new FourAltQuestion();
        question.setCorrectAlt(correctAlt);
        question.setSecondAlt(secondAlt);
        question.setThirdAlt(thirdAlt);
        question.setFourthAlt(fourthAlt);
    }
    
    @Test
    public void getCorrectAlt() {
        String r = question.getCorrectAlt();
        Assert.assertEquals(correctAlt, r);
    }

    @Test
    public void setCorrectAlt(){
        String correctTest = "CorrectTest";
        question.setCorrectAlt(correctTest);
        assertEquals(correctTest, question.getCorrectAlt());
    }

    @Test
    public void getAllAlternativesSize() {
        List<String> list = question.getAllAlternatives();

        assertEquals(3, list.size());
    }

    @Test
    public void checkAlternatives() {

        List<String> list = question.getAllAlternatives();
        assertEquals(secondAlt, list.get(0));
        assertEquals(thirdAlt, list.get(1));
        assertEquals(fourthAlt, list.get(2));

    }

    @Test
    public void setSecondAlt() {
        String secondTest = "SecondTest";
        question.setSecondAlt(secondTest);
        assertEquals(secondTest, question.getSecondAlt());
    }

    @Test
    public void setThirdAlt() {
        String thirdTest = "ThirdTest";
        question.setThirdAlt(thirdTest);
        assertEquals(thirdTest, question.getThirdAlt());
    }

    @Test
    public void setFourthAlt() {
        String fourthTest = "FourthTest";
        question.setFourthAlt(fourthTest);
        assertEquals(fourthTest, question.getFourthAlt());
    }
}