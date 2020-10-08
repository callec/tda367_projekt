package com.down_to_earth_rats.quiz_game.gamemode.infinite_quiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.down_to_earth_rats.quiz_game.databinding.FragmentInfGameModeBinding;
import com.down_to_earth_rats.quiz_game.gamemode.IGameModeFragment;
import com.down_to_earth_rats.quiz_game.gamemode.IGameModeObserver;

/**
 * Created by Carl Bergman
 * Represents a GameMode where you answers an infinite amount of questions
 * and can only guess wrongly three times.
 */
public class InfGameModeFragment extends Fragment implements IGameModeFragment {

    private FragmentInfGameModeBinding viewbinder;

    private InfGameMode model;
    private IGameModeObserver observer = null; // only allow one observer

    private ImageView life1;
    private ImageView life2;
    private ImageView life3;

    public InfGameModeFragment() {
        // Required empty public constructor
    }

    public static InfGameModeFragment newInstance() {
        InfGameModeFragment fragment = new InfGameModeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(InfGameMode.class);
        // possibly allow more than three lives, need to center more hearts in that case
        model.setLives(3);
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
        viewbinder = FragmentInfGameModeBinding.inflate(inflater, container, false);
        setupLives();
        return viewbinder.getRoot();
    }

    @Override
    public void answer(boolean a) {
        model.answer(a);
    }

    @Override
    public void addObserver(IGameModeObserver o) {
        if (this.observer == null) {
            this.observer = o;
        }
    }

    @Override
    public void notifyObserver() {
        if (this.observer != null) {
            this.observer.gameModeQuizEnd();
        }
    }
}