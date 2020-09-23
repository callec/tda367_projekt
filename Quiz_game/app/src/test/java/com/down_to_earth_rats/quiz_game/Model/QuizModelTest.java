package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 */

public class QuizModelTest {

    private IQuizModel model;

    @Before
    public void setUp() throws Exception {
        model = new QuizModel();
    }


    @Test
    public void insertQuestion() {
        List<IQuestion> list = new ArrayList<>();
        IQuestion testQuestion = new FourAltQuestion("Test Text", "1", "2", "3", "4");
        list.add(testQuestion);

        model.insertQuestions(new ListIterator<>(list));
        IQuestion returnQuestion = model.getQuestion();

        assertEquals(testQuestion, returnQuestion);
        assertEquals(testQuestion.getQuestionText(), returnQuestion.getQuestionText());

    }

    

}