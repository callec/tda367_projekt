package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

/**
 * Created by Carl Bergman
 */
public class StandardQuizViewModelTest {

    IViewModel vm;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        vm = new StandardQuizViewModel();
    }

    @Test
    public void testGetAlternativeList() {
        assertNotNull(vm.getAlternativeList().getValue());
    }

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
        boolean prevState = vm.getRunningState().getValue();
        // i don't particularly like this type casting but since we are testing
        // StandardQuizViewModel i think it is necessary
        ((StandardQuizViewModel) vm).quizFinished();

        assertNotEquals(prevState, vm.getRunningState().getValue());
    }
}
