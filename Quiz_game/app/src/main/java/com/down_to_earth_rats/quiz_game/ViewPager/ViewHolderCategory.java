package com.down_to_earth_rats.quiz_game.ViewPager;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.databinding.SubcategoryCardBinding;

public class ViewHolderCategory extends RecyclerView.ViewHolder {

    public SubcategoryCardBinding binding;

    public ViewHolderCategory(SubcategoryCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setText(String t){
        binding.categoryName.setText(t);
    }


}
