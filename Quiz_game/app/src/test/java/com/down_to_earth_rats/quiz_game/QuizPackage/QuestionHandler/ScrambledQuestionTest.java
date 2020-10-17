package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.FourAltQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 *
 */

public class ScrambledQuestionTest {
    private IQuestion testQuestion;
    private String questionText = "Hej";
    private ScrambledQuestion scrambledQuestion;


    @Before
    public void setUp() {
     testQuestion = new FourAltQuestion(questionText, "1", "2", "3", "4" );
     scrambledQuestion =  new ScrambledQuestion(testQuestion);

    }

    @Test
    public void testBinding() {
        assertEquals(scrambledQuestion.getQuestionText(), questionText);
    }

    @Test
    public void numberOfAlternatives() {
        Iterator<Tuple<String, Boolean>> iterator = scrambledQuestion.getAlternatives();

        int counter = 0;
        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(4, counter);

    }

    @Test
    public void checkIfCorrectAlternativeExists() {
        boolean correctAltFound = false;
        Iterator<Tuple<String, Boolean>> iterator = scrambledQuestion.getAlternatives();

        while(iterator.hasNext()){
            if(iterator.next().getValue2()){
                correctAltFound = !correctAltFound;
            }
        }

        assertTrue(correctAltFound);
    }



}