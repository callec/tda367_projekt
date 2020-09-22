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
        question = new FourAltQuestion(correctAlt, secondAlt, thirdAlt, fourthAlt);

    }
    
    @Test
    public void checkCorrectAlt() {
        String r = question.getCorrectAlternative();
        Assert.assertEquals(correctAlt, r);
    }

    @Test
    public void getAllAlternativesSize() {
        List<String> list = question.getFalseAlternatives();
        assertEquals(3, list.size());
    }

    @Test
    public void checkAlternatives() {
        List<String> list = question.getFalseAlternatives();
        assertEquals(secondAlt, list.get(0));
        assertEquals(thirdAlt, list.get(1));
        assertEquals(fourthAlt, list.get(2));

    }
}