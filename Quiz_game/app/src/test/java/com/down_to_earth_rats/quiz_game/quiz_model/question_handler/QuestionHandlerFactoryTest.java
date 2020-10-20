package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

import com.down_to_earth_rats.quiz_game.quiz_model.question_data.IQuestion;
import com.down_to_earth_rats.quiz_game.quiz_model.question_data.QuestionFactory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 */

public class QuestionHandlerFactoryTest {

    @Test
    public void testStandardModel() {

        List<IQuestion> list = new ArrayList<>();
        IQuestion testQuestion = QuestionFactory.createStandardFourAltQuestion("Test Text", "1", "2", "3", "4");
        list.add(testQuestion);

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(list.iterator());

        IQuestion returnQuestion = model.getQuestion();

        assertEquals(testQuestion.getQuestionText(), returnQuestion.getQuestionText());

    }
}