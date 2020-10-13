package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.TimeGameMode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

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

    private ProgressBar quizTimer;

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
        setupProgressBar();
        return viewbinder.getRoot();
    }

    private void setupProgressBar() {
        quizTimer = viewbinder.quizTimerProgressBar;

        new CountDownTimer(getArguments().getInt(getString(R.string.gamemode_time_value), 30) * 1000, 300) {

            @Override
            public void onTick(long millisUntilFinished) {
                quizTimer.incrementProgressBy(1);
                if (millisUntilFinished < 3000) { // TODO: put in settings time between questions
                    notifyObserver();
                }
            }

            @Override
            public void onFinish() {
                notifyObserver();
            }
        }.start();
    }

    @Override
    public void answer(boolean correct) {
        // do nothing, can't add time to a CountDownTimer
    }

    @Override
    public void addObserver(IGameModeObserver o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for (IGameModeObserver o : observers) {
            o.gameModeQuizEnd();
        }
    }

    @Override
    public void onNewQuestion() {
        // do nothing, can't pause or stop a CountDownTimer
    }
}