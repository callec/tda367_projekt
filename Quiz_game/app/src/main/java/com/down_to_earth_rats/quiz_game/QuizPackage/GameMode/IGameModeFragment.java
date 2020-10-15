package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode;

/**
 * Created by Carl Bergman
 * Holds methods required for every GameMode to have.
 */
public interface IGameModeFragment {
    /**
     * Report to the GameMode that your answer was correct or false.
     * @param a answer
     */
    void answer(boolean a);

    /**
     * Add an observer to the GameMode.
     * @param o observer
     */
    void addObserver(IGameModeObserver o);

    /**
     * Notifies the observers within the GameMode that the GameMode is finished.
     */
    void notifyObserver();

    /**
     * Reports to the GameMode that a new questions has appeared.
     */
    void onNewQuestion();
    // no static functions in interface with out language level, remember to implement it
    //static IGameModeFragment newInstance();
}
