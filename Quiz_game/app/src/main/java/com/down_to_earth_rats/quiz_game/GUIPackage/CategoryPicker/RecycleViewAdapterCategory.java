package com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.databinding.SubcategoryCardBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Simple adapter for the recycle view displaying the subcategories
 */

public class RecycleViewAdapterCategory extends RecyclerView.Adapter<ViewHolderCategory> {

    private List<String> dataSet;
    private ICategoryClickListener listener;

    public RecycleViewAdapterCategory(List<String> strings, ICategoryClickListener listener) {
        this.listener = listener;

        dataSet = new ArrayList<>();
        dataSet = strings;
    }

    @NonNull
    @Override
    public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SubcategoryCardBinding binding = SubcategoryCardBinding.inflate(layoutInflater, parent, false);

        return new ViewHolderCategory(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {
        holder.setText(dataSet.get(position));

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
