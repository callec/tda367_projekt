package com.down_to_earth_rats.quiz_game.ViewPager;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.SubcategoryCardBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapterCategory extends RecyclerView.Adapter<ViewHolderCategory> {

    List<String> dataset;

    public RecycleViewAdapterCategory(List<String> strings) {

        dataset = new ArrayList<>();

        dataset.addAll(strings);
    }

    @NonNull
    @Override
    public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SubcategoryCardBinding binding = SubcategoryCardBinding.inflate(layoutInflater, parent, false);


        return new ViewHolderCategory(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {
        holder.setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
