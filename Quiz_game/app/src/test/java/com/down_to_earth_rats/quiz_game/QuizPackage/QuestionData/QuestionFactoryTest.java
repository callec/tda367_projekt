package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Created by Carl Bergman
 */
public class QuestionFactoryTest {

    @Test
    public void testGetFourAltQuestion() {
        // testing methods in FourAltQuestion are done in FourAltQuestionText
        IQuestion factoryValue = QuestionFactory.createStandardFourAltQuestion("", "", "", "", "");
        assertTrue(factoryValue instanceof FourAltQuestion);
    }

}
