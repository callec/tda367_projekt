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






    @Test
    public void insertQuestions() {

        List<IQuestion> questions = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            questions.add(new FourAltQuestion("Text " + i, "First", "Second", "Third", "Fourth"));
        }

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        IQuestion q = model.getQuestion();

        boolean condition = false;

        for (IQuestion question : questions){
            if(question.getQuestionText().equals(q.getQuestionText())){
                condition = true;
                break;
            }
        }

        assertTrue(condition);

    }
}