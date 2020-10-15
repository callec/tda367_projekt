package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode;

/**
 * Created by Carl Bergman
 * Has a method that notifies the observer that the GameMode has ended.
 */
public interface IGameModeObserver {
    /**
     * Notify the observer that the GameMode has ended.
     */
    void gameModeQuizEnd();
}
