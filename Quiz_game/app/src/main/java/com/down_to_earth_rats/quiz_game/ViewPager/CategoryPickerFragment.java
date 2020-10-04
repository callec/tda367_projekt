package com.down_to_earth_rats.quiz_game.ViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.down_to_earth_rats.quiz_game.databinding.FragmentCategoryPickerBinding;

public class CategoryPickerFragment extends Fragment {

    private int num = 0;

    public CategoryPickerFragment(int number) {
        this.num = number;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentCategoryPickerBinding binding = FragmentCategoryPickerBinding.inflate(inflater);
        binding.textView4.setText(String.format("%d", num));



        return binding.getRoot();
    }
}