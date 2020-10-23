package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Carl Bergman
 * Holds and handles data for TimeGameMode to display.
 */
public class TimeGameMode extends ViewModel {

    private long maxTime;
    private long timeLeft;
    private long countDownInterval;
    private MutableLiveData<Boolean> quizRunning = new MutableLiveData<>();

    public TimeGameMode() {
        this.quizRunning.setValue(true);
    }

    /**
     * Initialise the attributes maxTimeLeft and countDownInterval from amount of seconds chosen
     * by user.
     *
     * @param seconds int length of the quiz in seconds
     */
    public void init(int seconds) {
        this.maxTime = seconds * 1000;
        this.countDownInterval = seconds * 10;
    }

    /**
     * @return long time left in ms
     */
    public long getTimeLeft() {
        return this.timeLeft;
    }

    /**
     * Set time left, in ms
     *
     * @param t long, time in ms
     */
    public void setTimeLeft(long t) {
        if (t < 1) {
            quizRunning.setValue(false);
            return;
        }
        this.timeLeft = t;
    }

    /**
     * @return long max time possible
     */
    public long getMaxTime() {
        return this.maxTime;
    }

    /**
     * @return long countdowninterval for the progressbar
     */
    public long getCountDownInterval() {
        return this.countDownInterval;
    }

    /**
     * @return MutableLiveData<Boolean> observable data if the gamemode is running
     */
    public MutableLiveData<Boolean> getQuizRunning() {
        return this.quizRunning;
    }
}
