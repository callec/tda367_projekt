package com.down_to_earth_rats.quiz_game.Model.QuestionHandler;

import com.down_to_earth_rats.quiz_game.Model.FourAltQuestion;
import com.down_to_earth_rats.quiz_game.Model.IQuestion;
import com.down_to_earth_rats.quiz_game.Model.QuestionHandler.IQuizModel;
import com.down_to_earth_rats.quiz_game.Model.QuestionHandler.ModelFactory;
import com.down_to_earth_rats.quiz_game.Model.Utility.ListIterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 */

public class ModelFactoryTest {

    @Test
    public void testStandardModel() {

        List<IQuestion> list = new ArrayList<>();
        IQuestion testQuestion = new FourAltQuestion("Test Text", "1", "2", "3", "4");
        list.add(testQuestion);

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(list));

        IQuestion returnQuestion = model.getQuestion();

        assertEquals(testQuestion.getQuestionText(), returnQuestion.getQuestionText());

    }
}