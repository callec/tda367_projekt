package com.down_to_earth_rats.quiz_game.gui.category_picker;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.databinding.SubcategoryCardBinding;

/**
 * Created by Erik Blomberg
 *
 * The layout used in the Recycler View to display one subcategory
 */

public class ViewHolderCategory extends RecyclerView.ViewHolder {

    public SubcategoryCardBinding binding;

    public ViewHolderCategory(final SubcategoryCardBinding binding, final ICategoryClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;

        //Configure the button to register clicks
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.categoryClicked("",String.valueOf(binding.categoryName.getText()) );
            }
        });
    }

    public void setText(String t){
        binding.categoryName.setText(t);
    }


}
