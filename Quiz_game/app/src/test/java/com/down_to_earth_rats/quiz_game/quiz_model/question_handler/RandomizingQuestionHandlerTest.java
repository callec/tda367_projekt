package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

import com.down_to_earth_rats.quiz_game.quiz_model.question_data.IQuestion;
import com.down_to_earth_rats.quiz_game.quiz_model.question_data.QuestionFactory;
import com.down_to_earth_rats.quiz_game.utility.ListIterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 */

public class RandomizingQuestionHandlerTest {

    @Test
    public void testInsertQuestions() {

        List<IQuestion> questions = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            questions.add(QuestionFactory.createStandardFourAltQuestion("Text " + i, "First", "Second", "Third", "Fourth"));
        }

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(new ListIterator<>(questions));

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
    public void testGetQuestionEmptyQuestion() {

        List<IQuestion> questions = new ArrayList<>();

        questions.add(QuestionFactory.createStandardFourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(new ListIterator<>(questions));

        model.nextQuestion();
        IQuestion question = model.getQuestion();

        assertEquals("", question.getQuestionText());

    }

    @Test
    public void testGetQuestionSame() {
        List<IQuestion> questions = new ArrayList<>();

        String questionText = "Test Text Text";

        questions.add(QuestionFactory.createStandardFourAltQuestion(questionText, "First", "Second", "Third", "Fourth"));

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(new ListIterator<>(questions));

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


        questions.add(QuestionFactory.createStandardFourAltQuestion(questionText1, "First", "Second", "Third", "Fourth"));
        questions.add(QuestionFactory.createStandardFourAltQuestion(questionText2, "First", "Second", "Third", "Fourth"));

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(new ListIterator<>(questions));

        IQuestion firstQuestion = model.getQuestion();

        model.nextQuestion();
        IQuestion secondQuestion = model.getQuestion();

        boolean stringsEqual = firstQuestion.getQuestionText().contentEquals(secondQuestion.getQuestionText());


        assertFalse(stringsEqual);
    }

    @Test
    public void testObserverQuizFinished() {
        List<IQuestion> questions = new ArrayList<>();

        questions.add(QuestionFactory.createStandardFourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(new ListIterator<>(questions));

        MockHandlerObserver observer = new MockHandlerObserver();
        model.registerObserver(observer);

        for (int i = 0; i < 2; i++) {
            model.nextQuestion();
        }

        assertTrue(observer.isCondition());

    }
    
    @Test
    public void testRemoveObserver(){
        List<IQuestion> questions = new ArrayList<>();

        questions.add(QuestionFactory.createStandardFourAltQuestion("Text", "First", "Second", "Third", "Fourth"));

        IQuestionHandler model = QuestionHandlerFactory.createRandomizingHandler(new ListIterator<>(questions));

        MockHandlerObserver observer = new MockHandlerObserver();
        model.registerObserver(observer);
        model.removeObserver(observer);

        model.getQuestion();

        assertFalse(observer.isCondition());

    }

    @Test
    public void testQuestionStackEmpty() {

        List<IQuestion> questions = new ArrayList<>();

        IQuestionHandler handler = QuestionHandlerFactory.createRandomizingHandler(questions.iterator());
        MockHandlerObserver observer = new MockHandlerObserver();
        handler.registerObserver(observer);
        handler.nextQuestion();
        assertTrue(observer.isCondition());
    }

    @Test
    public void testIsLastQuestion() {
        List<IQuestion> questions = new ArrayList<>();

        for (int i = 0; i < 2 ; i++) {
            questions.add(QuestionFactory.createStandardFourAltQuestion("Text " + i, "First", "Second", "Third", "Fourth"));
        }
        IQuestionHandler handler = QuestionHandlerFactory.createRandomizingHandler(questions.iterator());
        handler.nextQuestion();
        assertTrue(handler.isLastQuestion());
    }

    

}