package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

import com.down_to_earth_rats.quiz_game.gui.game_mode_fragments.LivesGameModeFragment;
import com.down_to_earth_rats.quiz_game.gui.game_mode_fragments.StandardGameModeFragment;
import com.down_to_earth_rats.quiz_game.gui.game_mode_fragments.TimeGameModeFragment;

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
