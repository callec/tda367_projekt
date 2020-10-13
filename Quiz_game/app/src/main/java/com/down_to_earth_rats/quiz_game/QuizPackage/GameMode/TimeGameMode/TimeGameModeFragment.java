package com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.TimeGameMode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.down_to_earth_rats.quiz_game.databinding.FragmentTimeGameModeBinding;
import com.down_to_earth_rats.quiz_game.R;

/**
 * Created by Carl Bergman
 */
public class TimeGameModeFragment extends Fragment {

    private FragmentTimeGameModeBinding viewbinder;

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
        return viewbinder.getRoot();
    }
}