package com.down_to_earth_rats.quiz_game.Model.QuestionHandler;

import com.down_to_earth_rats.quiz_game.Model.FourAltQuestion;
import com.down_to_earth_rats.quiz_game.Model.IQuestion;
import com.down_to_earth_rats.quiz_game.Model.QuestionHandler.IModelObserver;
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

public class QuizModelTest {

    @Test
    public void testInsertQuestions() {

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
    public void testObserverQuizFinished() {
        List<IQuestion> questions = new ArrayList<>();

        questions.add(new FourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        TestModelObserver observer = new TestModelObserver();
        model.registerObserver(observer);

        model.answerQuestion(false);

        assertTrue(observer.isCondition());

    }

    @Test
    public void testGetQuestionEmptyQuestion() {

        List<IQuestion> questions = new ArrayList<>();

        questions.add(new FourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        model.answerQuestion(true);
        IQuestion question = model.getQuestion();

        assertEquals("", question.getQuestionText());

    }

    @Test
    public void testGetQuestionSame() {
        List<IQuestion> questions = new ArrayList<>();

        String questionText = "Test Text Text";

        questions.add(new FourAltQuestion(questionText, "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        IQuestion question1 = model.getQuestion();
        IQuestion question2 = model.getQuestion();


        boolean stringsEqual = question1.getQuestionText().contentEquals(question2.getQuestionText());

        assertTrue(stringsEqual);
    }

    @Test
    public void testGetQuestionDifferent() {
        List<IQuestion> questions = new ArrayList<>();

        String questionText1 = "TestText1";
        String questionText2 = "TestText2";


        questions.add(new FourAltQuestion(questionText1, "First", "Second", "Third", "Fourth"));
        questions.add(new FourAltQuestion(questionText2, "First", "Second", "Third", "Fourth"));

        IQuizModel model = ModelFactory.createStandardModel(new ListIterator<>(questions));

        IQuestion firstQuestion = model.getQuestion();

        model.answerQuestion(false);
        IQuestion secondQuestion = model.getQuestion();

        boolean stringsEqual = firstQuestion.getQuestionText().contentEquals(secondQuestion.getQuestionText());


        assertFalse(stringsEqual);
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

    static class TestModelObserver implements IModelObserver {

        private boolean condition = false;

        @Override
        public void quizFinished() {
            condition = true;
        }

        public boolean isCondition() {
            return condition;
        }
    }

}