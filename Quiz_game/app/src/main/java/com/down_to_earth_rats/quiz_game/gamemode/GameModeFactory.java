package com.down_to_earth_rats.quiz_game.gamemode;

import com.down_to_earth_rats.quiz_game.gamemode.infinite_quiz.InfGameModeFragment;
import com.down_to_earth_rats.quiz_game.gamemode.standard.StandardGameModeFragment;

/**
 * Created by Carl Bergman
 */
public class GameModeFactory {
    public GameModeFactory() {}

    public static IGameModeFragment createInfinityQuiz() {
        return InfGameModeFragment.newInstance();
    }

    public static IGameModeFragment createStandardQuiz() {
        return StandardGameModeFragment.newInstance();
    }
}
