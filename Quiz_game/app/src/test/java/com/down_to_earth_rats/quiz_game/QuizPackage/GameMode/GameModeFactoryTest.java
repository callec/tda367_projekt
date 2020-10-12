package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode;

import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Lives.LivesGameModeFragment;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Standard.StandardGameModeFragment;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by Carl Bergman
 */
public class GameModeFactoryTest {

    @Test
    public void testCreateStandardQuiz() {
        IGameModeFragment gamemode = GameModeFactory.createStandardQuiz();
        assertTrue(gamemode instanceof StandardGameModeFragment);
    }

    @Test
    public void testCreateLivesQuiz() {
        IGameModeFragment gamemode = GameModeFactory.createLivesQuiz();
        assertTrue(gamemode instanceof LivesGameModeFragment);
    }
}
