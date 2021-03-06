package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Carl Bergman
 * Holds and handles data for LivesGameModeFragment to display.
 */
public class LivesGameMode extends ViewModel {

    private MutableLiveData<Integer> lives = new MutableLiveData<>();
    private int nCorrect = 0;

    public LivesGameMode() {
        lives.setValue(3);
    }

    /**
     * Reset the gamemode.
     */
    public void reset() {
        lives.setValue(3);
    }

    /**
     * How many lives there are left.
     *
     * @return MutableLiveData<Integer> observable integer
     */
    public MutableLiveData<Integer> getLives() {
        return lives;
    }

    /**
     * Answer a question within the gamemode
     *
     * @param correct boolean, correct/wrong answer
     */
    public void answer(boolean correct) {
        if (!correct) {
            lives.setValue(lives.getValue() - 1);
            nCorrect = 0; // need 5 correct in a row
        } else {
            if (++nCorrect == 5 && lives.getValue() != 3) {
                lives.setValue(lives.getValue() + 1);
                nCorrect = 0;
            }
        }
    }
}
