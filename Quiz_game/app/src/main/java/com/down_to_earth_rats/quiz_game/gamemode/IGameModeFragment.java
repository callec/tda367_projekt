package com.down_to_earth_rats.quiz_game.gamemode;

public interface IGameModeFragment {
    void answer(boolean a);
    void addObserver(IGameModeObserver o);
    void notifyObserver();
}
