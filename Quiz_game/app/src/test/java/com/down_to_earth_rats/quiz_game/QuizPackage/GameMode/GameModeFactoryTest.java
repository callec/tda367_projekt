package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode;

import com.down_to_earth_rats.quiz_game.GUIPackage.GameMode.LivesGameModeFragment;
import com.down_to_earth_rats.quiz_game.GUIPackage.GameMode.StandardGameModeFragment;
import com.down_to_earth_rats.quiz_game.GUIPackage.GameMode.TimeGameModeFragment;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by Carl Bergman
 */
public class GameModeFactoryTest {

    @Test
    public void testCreateStandardQuiz() {
        IGameModeFragment gamemode = GameModeFactory.getGameMode("Standard");
        assertTrue(gamemode instanceof StandardGameModeFragment);
    }

    @Test
    public void testCreateLivesQuiz() {
        IGameModeFragment gamemode = GameModeFactory.getGameMode("Max tre fel");
        assertTrue(gamemode instanceof LivesGameModeFragment);
    }

    @Test
    public void testCreateTimeQuiz() {
        IGameModeFragment gamemode = GameModeFactory.getGameMode("Tidspress");
        assertTrue(gamemode instanceof TimeGameModeFragment);
    }
}
