package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Created by Carl Bergman
 */
public class QuestionProviderFactoryTest {

    @Test
    public void testGetStandardQuestionProvider() {
        // testing methods in QuestionsFromFile are done in QuestionsFromFileTest
        IQuestionProvider factoryValue = QuestionProviderFactory.getStandardQuestionProvider();
        assertTrue(factoryValue instanceof QuestionsFromFile);
    }
}
