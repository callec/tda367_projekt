package com.down_to_earth_rats.quiz_game.gamemode.gamemode_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.down_to_earth_rats.quiz_game.databinding.FragmentInfGameModeBinding;
import com.down_to_earth_rats.quiz_game.gamemode.InfGameMode;
import com.down_to_earth_rats.quiz_game.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfGameModeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfGameModeFragment extends Fragment implements IGameModeFragment {

    private FragmentInfGameModeBinding viewbinder;
    private FragmentTransaction ft;

    private InfGameMode model;

    private ImageView life1;
    private ImageView life2;
    private ImageView life3;

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
        }
        ft = getActivity().getSupportFragmentManager().beginTransaction();

        model = new ViewModelProvider(this).get(InfGameMode.class);
        //model.setLives(this.getArguments().getInt(getString(R.string.gamemode_lives), 3));
        model.setLives(3);

        viewbinder = FragmentInfGameModeBinding.inflate(getLayoutInflater());
        setupLives();
    }

    private void setupLives() throws ArrayIndexOutOfBoundsException {
        life1 = viewbinder.life1ImageView;
        life2 = viewbinder.life2ImageView;
        life3 = viewbinder.life3ImageView;

        model.getLives().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer n) {
                switch (n) {
                    case 0:
                        // kill quiz
                        break;
                    case 1:
                        life1.setVisibility(View.VISIBLE);
                        life2.setVisibility(View.GONE);
                        life3.setVisibility(View.GONE);
                        break;
                    case 2:
                        life1.setVisibility(View.VISIBLE);
                        life2.setVisibility(View.VISIBLE);
                        life3.setVisibility(View.GONE);
                        break;
                    case 3:
                        life1.setVisibility(View.VISIBLE);
                        life2.setVisibility(View.VISIBLE);
                        life3.setVisibility(View.VISIBLE);
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException("Maximum three lives, something has gone wrong.");
                }
                updateUI();
            }
        });
    }

    private void updateUI() {
        // TODO fix this
        //getActivity().getSupportFragmentManager().beginTransaction().detach(this).commitNowAllowingStateLoss();
        ft.replace(R.id.fragment_container, this).commit();

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