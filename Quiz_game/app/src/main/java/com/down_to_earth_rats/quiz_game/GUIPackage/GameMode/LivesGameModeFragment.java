package com.down_to_earth_rats.quiz_game.GUIPackage.GameMode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Lives.LivesGameMode;
import com.down_to_earth_rats.quiz_game.databinding.FragmentLivesGameModeBinding;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeFragment;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carl Bergman
 * Represents a GameMode where you answer an large amount of questions
 * and can only guess wrongly three times.
 * It is a fragment with three ImageViews that represent the lives/tries.
 */
public class LivesGameModeFragment extends Fragment implements IGameModeFragment {

    private FragmentLivesGameModeBinding viewbinder;

    private LivesGameMode model;
    private List<IGameModeObserver> observers = new ArrayList<>();

    private ImageView life1, life2, life3;

    public LivesGameModeFragment() {
        // Required empty public constructor
    }

    /**
     * {@inheritDoc}
     */
    public static IGameModeFragment newInstance() {
        LivesGameModeFragment fragment = new LivesGameModeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(LivesGameMode.class);
        // possibly allow more than three lives, need to center more hearts in that case
        //model.setLives(3);
    }

    private void setupLives() throws ArrayIndexOutOfBoundsException {
        life1 = viewbinder.life1ImageView;
        life2 = viewbinder.life2ImageView;
        life3 = viewbinder.life3ImageView;

        model.getLives().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer n) {
                switch (n) {
                    case 0:
                        life1.setVisibility(View.INVISIBLE);
                        life2.setVisibility(View.INVISIBLE);
                        life3.setVisibility(View.INVISIBLE);
                        notifyObserver();
                        break;
                    case 1:
                        life1.setVisibility(View.VISIBLE);
                        life2.setVisibility(View.INVISIBLE);
                        life3.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        life1.setVisibility(View.VISIBLE);
                        life2.setVisibility(View.VISIBLE);
                        life3.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        life1.setVisibility(View.VISIBLE);
                        life2.setVisibility(View.VISIBLE);
                        life3.setVisibility(View.VISIBLE);
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("Maximum three lives, something has gone wrong.");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewbinder = FragmentLivesGameModeBinding.inflate(inflater, container, false);
        setupLives();
        return viewbinder.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void answer(boolean a) {
        model.answer(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(IGameModeObserver o) {
        this.observers.add(o);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObserver() {
        for (IGameModeObserver o : this.observers) {
            o.gameModeQuizEnd();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNewQuestion() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        model.reset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pause() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resume() {
        // do nothing
    }
}