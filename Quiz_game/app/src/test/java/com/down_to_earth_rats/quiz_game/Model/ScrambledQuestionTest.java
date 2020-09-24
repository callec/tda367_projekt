package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ScrambledQuestionTest {
    private IQuestion testQuestion;
    private String questionText = "Hej";
    private ScrambledQuestion scrambledQuestion;
    @Before
    public void setUp() throws Exception {
     testQuestion = new FourAltQuestion(questionText, "1", "2", "3", "4" );
     scrambledQuestion =  new ScrambledQuestion();

    }

    @Test
    public void testBinding() {
        scrambledQuestion.setBaseQuestion(testQuestion);
        assertEquals(scrambledQuestion.getQuestionText(), questionText);
    }

    @Test
    public void failedBindingText() {
        String response = scrambledQuestion.getQuestionText();
        assertEquals("", response);
    }

    @Test
    public void failedBindingIterator() {
        int counter = 0;
        Iterator<Tuple<String, Boolean>> iterator = scrambledQuestion.getAlternatives();

        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(0, counter);

    }

    @Test
    public void numberOfAlternatives() {
        scrambledQuestion.setBaseQuestion(testQuestion);
        Iterator<Tuple<String, Boolean>> iterator = scrambledQuestion.getAlternatives();

        int counter = 0;
        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(4, counter);

    }

    @Test
    public void checkCorrectAlternative() {
        scrambledQuestion.setBaseQuestion(testQuestion);
        boolean correctAltFound = false;
        Iterator<Tuple<String, Boolean>> iterator = scrambledQuestion.getAlternatives();

        while(iterator.hasNext()){
            if(iterator.next().getValue2()){
                correctAltFound = !correctAltFound;
            }
        }

        assertTrue(correctAltFound);
    }


   /* @Test
    public void yes() {

        Iterator<Tuple<String, Boolean>> iterator = scrambledQuestion.getAlternatives();

        while(iterator.hasNext()){
            System.out.println(iterator.next().getValue1());
        }
    }*/
}