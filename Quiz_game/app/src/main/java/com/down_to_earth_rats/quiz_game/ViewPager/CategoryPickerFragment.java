package com.down_to_earth_rats.quiz_game.ViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.down_to_earth_rats.quiz_game.databinding.FragmentCategoryPickerBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryPickerFragment extends Fragment {

    private int num = 0;

    public CategoryPickerFragment(int number) {
        this.num = number;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Test" + num);

        }


        // Inflate the layout for this fragment
        FragmentCategoryPickerBinding binding = FragmentCategoryPickerBinding.inflate(inflater);
        RecyclerView recyclerView = binding.list;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        recyclerView.setAdapter(new RecycleViewAdapterCategory(list));


        return binding.getRoot();
    }
}