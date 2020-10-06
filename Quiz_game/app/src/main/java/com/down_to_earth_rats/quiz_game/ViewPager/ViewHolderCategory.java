package com.down_to_earth_rats.quiz_game.ViewPager;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.databinding.SubcategoryCardBinding;

/**
 * Created by Erik Blomberg
 *
 */

public class ViewHolderCategory extends RecyclerView.ViewHolder {

    public SubcategoryCardBinding binding;

    public ViewHolderCategory(final SubcategoryCardBinding binding, final CategoryClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.CategoryClicked("",String.valueOf(binding.categoryName.getText()) );
            }
        });
    }

    public void setText(String t){
        binding.categoryName.setText(t);
    }


}
