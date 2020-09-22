package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class FourAltQuestionTest {

    private IQuestion question;

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
        int counter = 0;
        Iterator<String> iterator = question.getFalseAlternatives();

        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(3, counter);

    }

    @Test
    public void checkAlternatives() {
        Iterator<String> iterator = question.getFalseAlternatives();

        iterator.hasNext();
        assertEquals(secondAlt, iterator.next());

        iterator.hasNext();

        assertEquals(thirdAlt, iterator.next());

        iterator.hasNext();
        assertEquals(fourthAlt,iterator.next());

    }
}