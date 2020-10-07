package com.down_to_earth_rats.quiz_game.QuizPackage.gamemode;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * Created by Carl Bergman
 * Interface for specific tasks that the GameMode has to perform
 */
public interface IGameMode {

    // TODO: make set/get generic?
    // problem with this!!!

    /**
     * Set data used within the GameMode.
     * @param data List with types of some subclass of number
     */
    void setData(List<? extends Number> data);
    List<? extends Number> getData();
    MutableLiveData<Boolean> getQuizRunning();
    void answer(boolean correct);
}
