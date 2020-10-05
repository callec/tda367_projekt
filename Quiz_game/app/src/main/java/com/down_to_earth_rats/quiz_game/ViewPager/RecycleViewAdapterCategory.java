package com.down_to_earth_rats.quiz_game.ViewPager;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.databinding.SubcategoryCardBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterCategory extends RecyclerView.Adapter<ViewHolderCategory> implements SubCategoryClickListener {

    private List<String> dataSet;

    public RecycleViewAdapterCategory(List<String> strings) {

        dataSet = new ArrayList<>();
        dataSet.addAll(strings);
    }

    @NonNull
    @Override
    public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SubcategoryCardBinding binding = SubcategoryCardBinding.inflate(layoutInflater, parent, false);

        return new ViewHolderCategory(binding, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {
        holder.setText(dataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public void subjectClicked(String name) {
        System.out.println(name);
    }
}
