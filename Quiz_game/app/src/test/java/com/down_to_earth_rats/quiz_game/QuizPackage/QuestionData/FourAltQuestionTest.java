package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData;

import com.down_to_earth_rats.quiz_game.Utility.Tuple;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 */

public class FourAltQuestionTest {

    private IQuestion question;

    private String correctAlt = "Correct";
    private String secondAlt = "Two";
    private String thirdAlt = "Third";
    private String fourthAlt = "Fourth";

    private String questionText = "This is a question text";

    @Before
    public void initialize(){
        question = new FourAltQuestion(questionText, correctAlt, secondAlt, thirdAlt, fourthAlt);

    }

    @Test
    public void getQuestionText() {
        String text = question.getQuestionText();
        assertEquals(questionText, text);
    }

    @Test
    public void checkCorrectAlt() {
        boolean correctAltFound = false;
        Iterator<Tuple<String, Boolean>> iterator = question.getAlternatives();

        while(iterator.hasNext()){

            if(iterator.next().getValue2()){
                correctAltFound = !correctAltFound;
            }
        }

        assertTrue(correctAltFound);
    }

    @Test
    public void getAllAlternativesSize() {
        int counter = 0;
        Iterator<Tuple<String, Boolean>> iterator = question.getAlternatives();

        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(4, counter);

    }

    @Test
    public void checkAlternatives() {
        Iterator<Tuple<String, Boolean>> iterator = question.getAlternatives();

        iterator.hasNext();
        assertEquals(correctAlt, iterator.next().getValue1());

        iterator.hasNext();
        assertEquals(secondAlt, iterator.next().getValue1());

        iterator.hasNext();
        assertEquals(thirdAlt, iterator.next().getValue1());

        iterator.hasNext();
        assertEquals(fourthAlt,iterator.next().getValue1());

    }


}