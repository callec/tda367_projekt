package com.down_to_earth_rats.quiz_game.gamemode;

import com.down_to_earth_rats.quiz_game.gamemode.lives.livesGameModeFragment;
import com.down_to_earth_rats.quiz_game.gamemode.standard.StandardGameModeFragment;

/**
 * Created by Carl Bergman
 */
public class GameModeFactory {
    public GameModeFactory() {}

    public static IGameModeFragment createInfinityQuiz() {
        return livesGameModeFragment.newInstance();
    }

    public static IGameModeFragment createStandardQuiz() {
        return StandardGameModeFragment.newInstance();
    }
}
