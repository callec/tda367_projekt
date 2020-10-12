package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode;

import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Lives.LivesGameModeFragment;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Standard.StandardGameModeFragment;

/**
 * Created by Carl Bergman
 */
public class GameModeFactory {

    public static IGameModeFragment createLivesQuiz() {
        return LivesGameModeFragment.newInstance();
    }

    public static IGameModeFragment createStandardQuiz() {
        return StandardGameModeFragment.newInstance();
    }
}
