package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

/**
 * Created by Carl Bergman
 * Small modification by Erik Blomberg
 */
public class StandardQuizViewModelTest {

    ViewModel vm;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        vm = new StandardQuizViewModel();
    }

    /*@Test
    public void testGetAlternativeList() {
        assertNotNull(vm.getAlternativeList().getValue());
    }*/

    @Test
    public void testGetTotalQuestions() {
        assertNotEquals(0, vm.getTotalQuestions());
    }

    @Test
    public void testChangeQuestion() {
        List<String> alts = vm.getAlternativeList().getValue();
        vm.changeQuestion();

        assertNotEquals(alts, vm.getAlternativeList().getValue());
    }

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

    @Test
    public void testQuizFinished() {
        int totalq = vm.getTotalQuestions();
        Boolean prevState = vm.getRunningState().getValue();
        if(prevState == null){
            fail();
        }

        for (int i = 0; i < totalq; i++) {
            vm.answerQuestion(1);
            vm.changeQuestion();
        }

        assertNotEquals(prevState, vm.getRunningState().getValue());
    }

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
}
