package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.FourAltQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.ListIterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 */

public class ModelFactoryTest {

    @Test
    public void testStandardModel() {

        List<IQuestion> list = new ArrayList<>();
        IQuestion testQuestion = new FourAltQuestion("Test Text", "1", "2", "3", "4");
        list.add(testQuestion);

        IQuestionHandler model = ModelFactory.createStandardModel(list.iterator());

        IQuestion returnQuestion = model.getQuestion();

        assertEquals(testQuestion.getQuestionText(), returnQuestion.getQuestionText());

    }
}