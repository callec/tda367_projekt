package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.Standard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.down_to_earth_rats.quiz_game.databinding.FragmentStandardGameModeBinding;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeFragment;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeObserver;

/**
 * Created by Carl Bergman
 * All standard functionality is in QuizPackage so this does nothing
 */
public class StandardGameModeFragment extends Fragment implements IGameModeFragment {

    private FragmentStandardGameModeBinding viewbinder;

    public StandardGameModeFragment() {
        // Required empty public constructor
    }

    public static StandardGameModeFragment newInstance() {
        StandardGameModeFragment fragment = new StandardGameModeFragment();
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
        viewbinder = FragmentStandardGameModeBinding.inflate(inflater, container, false);
        return viewbinder.getRoot();
    }

    @Override
    public void answer(boolean a) {
        // do nothing
    }

    @Override
    public void addObserver(IGameModeObserver o) {
        // do nothing
    }

    @Override
    public void notifyObserver() {
        // do nothing
    }
}