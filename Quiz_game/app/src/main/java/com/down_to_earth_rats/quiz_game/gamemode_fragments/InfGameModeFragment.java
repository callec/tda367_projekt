package com.down_to_earth_rats.quiz_game.gamemode_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.down_to_earth_rats.quiz_game.QuizActivity;
import com.down_to_earth_rats.quiz_game.QuizPackage.gamemode.IGameMode;
import com.down_to_earth_rats.quiz_game.QuizPackage.gamemode.InfGameMode;
import com.down_to_earth_rats.quiz_game.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfGameModeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfGameModeFragment extends Fragment implements IGameModeFragment {

    private IGameMode model;

    public InfGameModeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static InfGameModeFragment newInstance() {
        InfGameModeFragment fragment = new InfGameModeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            model = new ViewModelProvider(this).get(InfGameMode.class);
            List<Integer> data = new ArrayList<>();
            data.add(this.getArguments().getInt(getString(R.string.gamemode_lives), 3));
            model.setData(data);
        }

        model.getQuizRunning().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean state) {
                if (!state) {
                    // kill quiz
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inf_game_mode, container, false);
    }

    @Override
    public void answer(boolean a) {
        model.answer(a);
    }
}