package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.QuestionsFromFile;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Created by Carl Bergman
 * Small modification by Erik Blomberg, Sara Persson
 */
public class StandardQuizViewModelTest {

    IViewModel vm;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        vm = new StandardQuizViewModel();
        vm.setTotalQuestions(5);
        vm.initQuiz();
    }

    @Test
    public void testCheckIfCorrect() {
        int amountOfQuestions = 4;
        for (int n = 1; n<amountOfQuestions; n++) { //there is only one true answer or no true answer.
        assertFalse(vm.checkIfCorrect(n)&&vm.checkIfCorrect(n+1));
        }                                           //there is a true answer.
        assertTrue(vm.checkIfCorrect(1)||vm.checkIfCorrect(2)
                           ||vm.checkIfCorrect(3)||vm.checkIfCorrect(4));

    }

    @Test
    public void TestGetHintIndex() {
        //int amountOfQuestions = 4;
        vm.setTotalQuestions(100000);
        vm.initQuiz();

        for (int i = 0; i < 100000; i++) {
            vm.answerQuestion(vm.getHintIndex()+1);
            vm.changeQuestion();
        }
        assert vm.getCorrectAnswers() == 0;

    }

    @Test
    public void TestGetHintsUsed () {
        assert vm.GetHintsUsed() == false;
        vm.hintsUsedResults();
        assert vm.GetHintsUsed() == true;
    }

    @Test
    public void TestSetHintsUsed () {
        assert vm.GetHintsUsed() == false;
        vm.SetHintsUsed(true);
        assert vm.GetHintsUsed() == true;
    }

    @Test
    public void TesthintsUsedResults () {
        assertFalse(vm.GetHintsUsed());
        vm.hintsUsedResults();
        assertTrue(vm.GetHintsUsed());
    }

    @Test
    public void testGetTotalQuestions() {
        assertNotEquals(0, vm.getTotalQuestions());
    }


    /* TODO this test fails atm, whyy? Fix pls!
    @Test
    public void testChangeQuestion() {
        List<String> alts = vm.getAlternativeList().getValue();
        vm.changeQuestion();

        assertNotEquals(alts, vm.getAlternativeList().getValue());
    }

     */

    @Test
    public void testAnswerQuestions() {
        int firstResult = vm.getCorrectAnswers();

        // since the alternatives are always shuffled we run through them to make sure we get
        // at least one correct answer.
        int c = 1;
        while (!vm.answerQuestion(c)) {
            ++c;
            if (c > 4) {
                vm.changeQuestion();
                c = 1;
            }
        }

        assertNotEquals(firstResult, vm.getCorrectAnswers());
    }



    /*
    @Test
    public void testGetIsLast() {
        int totalq = vm.getTotalQuestions();
        Boolean prevIsLast = vm.getIsLast().getValue();
        if (prevIsLast == null) {
            fail();
        }

        for (int i=0; i<totalq; ++i) {
            vm.answerQuestion(1);
            if (i<(totalq-1)) {
                // this feels like a stupid addition but it emulates how the quiz works as
                // the vm instantly notifies activity when the last question happens so this
                // method never gets to run after the last question
                vm.changeQuestion();
            }
        }

        assertNotEquals(prevIsLast, vm.getIsLast().getValue());
    }

     */

    @Test
    public void gameModeForceEndTest() {
        Boolean previousvalue = vm.getIsLast().getValue();
        if (previousvalue == null) {
            fail();
        }

        vm.gameModeForceEnd();
        assertNotEquals(previousvalue, vm.getIsLast().getValue());
    }
}
