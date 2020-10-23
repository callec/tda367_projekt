package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

/**
 * Created by Carl Bergman
 * Holds methods required for every GameMode to have.
 */
public interface IGameModeFragment {
    /**
     * Report to the GameMode that your answer was correct or false.
     *
     * @param a answer
     */
    void answer(boolean a);

    /**
     * Add an observer to the GameMode.
     *
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

    /**
     * Resets the GameMode to as it was in the beginning.
     */
    void reset();

    /**
     * For GameModes which are time dependent, this method pauses.
     */
    void pause();

    /**
     * For GameModes which are time dependent, this method resumes.
     */
    void resume();
}
