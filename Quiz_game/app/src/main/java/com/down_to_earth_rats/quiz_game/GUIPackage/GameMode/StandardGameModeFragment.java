package com.down_to_earth_rats.quiz_game.GUIPackage.GameMode;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.StandardGameMode;
import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.FragmentStandardGameModeBinding;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeFragment;
import com.down_to_earth_rats.quiz_game.QuizPackage.GameMode.IGameModeObserver;

/**
 * Created by Carl Bergman
 * This class represents the standard GameMode. Most functionality is in QuizActivity and the model
 * but this keeps track of answered questions and how many is left.
 */
public class StandardGameModeFragment extends Fragment implements IGameModeFragment {

    private FragmentStandardGameModeBinding viewbinder;
    private StandardGameMode model;

    private TextView nqTextView;

    public StandardGameModeFragment() {
        // Required empty public constructor
    }

    /**
     * {@inheritDoc}
     */
    public static IGameModeFragment newInstance() {
        StandardGameModeFragment fragment = new StandardGameModeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(StandardGameMode.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewbinder = FragmentStandardGameModeBinding.inflate(inflater, container, false);
        setupTextViews();
        return viewbinder.getRoot();
    }

    private void setupTextViews() {
        nqTextView = viewbinder.nqTextView;

        assert this.getArguments() != null;
        final Integer totalq = this.getArguments().getInt(getActivity().getString(R.string.settings_totalq), 10);

        model.getCurrentq().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer.equals(totalq)) {
                    return;
                }
                String s = getActivity().getString(R.string.gamemode_standard_which_q, integer+1, totalq);
                nqTextView.setText(s);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void answer(boolean a) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(IGameModeObserver o) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObserver() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNewQuestion() {
        model.nextQuestion();
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