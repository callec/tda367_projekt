package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.TimeGameMode;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeFragment;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeObserver;
import com.down_to_earth_rats.quiz_game.databinding.FragmentTimeGameModeBinding;
import com.down_to_earth_rats.quiz_game.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl Bergman
 */
public class TimeGameModeFragment extends Fragment implements IGameModeFragment {

    private FragmentTimeGameModeBinding viewbinder;

    private ProgressBar timerProgressBar;
    private CountDownTimer timer;
    private long timeLeft;
    private long countDownInterval;
    private boolean quizRunning;

    private List<IGameModeObserver> observers = new ArrayList<>();

    public TimeGameModeFragment() {
        // Required empty public constructor
    }

    public static TimeGameModeFragment newInstance() {
        TimeGameModeFragment fragment = new TimeGameModeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewbinder = FragmentTimeGameModeBinding.inflate(inflater, container, false);
        quizRunning = true;
        setupProgressBar();
        return viewbinder.getRoot();
    }

    private void setupProgressBar() {
        timerProgressBar = viewbinder.quizTimerProgressBar;
        int seconds = getArguments().getInt(getString(R.string.gamemode_time_value), 30);
        countDownInterval = seconds * 10;
        timerStart(seconds * 1000);

    }

    private void timerStart(long time) {
        timer = new CountDownTimer(time, countDownInterval) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerProgressBar.incrementProgressBy(1);
                timeLeft = millisUntilFinished;
                /*if (millisUntilFinished < 3000) { // TODO: put in settings time between questions
                    notifyObserver();
                }*/
            }

            @Override
            public void onFinish() {
                notifyObserver();
            }
        };

        timer.start();
    }

    @Override
    public void answer(boolean correct) {
        timer.cancel();
        timerProgressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.colorDarkGrey)));
        //timeLeft += 2000;
    }

    @Override
    public void addObserver(IGameModeObserver o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver() {
        quizRunning = false;
        timerProgressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.colorDarkGrey)));
        for (IGameModeObserver o : observers) {
            o.gameModeQuizEnd();
        }
    }

    @Override
    public void onNewQuestion() {
        if (!quizRunning) {
            return;
        }
        timerStart(timeLeft);
        timerProgressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.colorAccent)));
    }
}