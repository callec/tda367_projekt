package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Erik Blomberg, Louise Tranborg
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

    @Test
    public void testObserverLastQuestion() {
        List<IQuestion> questions = new ArrayList<>();

        questions.add(new FourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        TestModelObserver observer = new TestModelObserver();
        model.registerObserver(observer);

        model.getQuestion();

        assertTrue(observer.isCondition());



    }

    @Test
    public void testGetQuestionEmptyQuestion() {

        List<IQuestion> questions = new ArrayList<>();

        questions.add(new FourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        model.getQuestion();

        IQuestion question = model.getQuestion();

        assertEquals("", question.getQuestionText());

    }


    @Test
    public void testRemoveObserver(){
        List<IQuestion> questions = new ArrayList<>();

        questions.add(new FourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        TestModelObserver observer = new TestModelObserver();
        model.registerObserver(observer);
        model.removeObserver(observer);

        model.getQuestion();

        assertFalse(observer.isCondition());



    }


    @Test
    public void testTotal() {
        List<IQuestion> questions = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            questions.add(new FourAltQuestion("Text " + i, "First", "Second", "Third", "Fourth"));
        }

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        assertEquals(10, model.getTotalQuestions());
    }

    @Test
    public void testResult() {

        List<IQuestion> questions = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            questions.add(new FourAltQuestion("Text " + i, "First", "Second", "Third", "Fourth"));
        }

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        model.answerQuestion(true);
        model.answerQuestion(false);

        assertEquals(1, model.getResult());

    }

    static class TestModelObserver implements IModelObserver{

        private boolean condition = false;

        @Override
        public void lastQuestion() {
            condition = true;
        }

        public boolean isCondition() {
            return condition;
        }
    }

}