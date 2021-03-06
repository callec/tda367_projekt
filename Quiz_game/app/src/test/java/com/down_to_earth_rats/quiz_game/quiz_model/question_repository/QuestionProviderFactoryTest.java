package com.down_to_earth_rats.quiz_game.quiz_model.question_repository;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Carl Bergman
 */
public class QuestionProviderFactoryTest {

    @Test
    public void testGetStandardQuestionProvider() {
        // testing methods in QuestionsFromFile are done in QuestionsFromFileTest
        IQuestionProvider factoryValue = QuestionProviderFactory.getQuestionProvider();
        assertTrue(factoryValue instanceof SimpleQuestionProvider);
    }
}
