package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode;

/**
 * Created by Carl Bergman
 */
public interface IGameModeFragment {
    void answer(boolean a);
    void addObserver(IGameModeObserver o);
    void notifyObserver();
    void onNewQuestion();
    // no static functions in interface with out language level, remember to implement it
    //static IGameModeFragment newInstance();
}
