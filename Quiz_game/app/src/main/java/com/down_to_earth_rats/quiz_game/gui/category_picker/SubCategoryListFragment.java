package com.down_to_earth_rats.quiz_game.gui.category_picker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.category.ICategory;
import com.down_to_earth_rats.quiz_game.databinding.FragmentCategoryPickerBinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Fragment displaying a list with Subcategories from a specific category
 */

public class SubCategoryListFragment extends Fragment implements ICategoryClickListener {

    private ICategoryClickListener listener;

    private ICategory category;
    private final List<String> subCategories = new ArrayList<>();

    private RecyclerView recyclerView;


    public void setListener(ICategoryClickListener listener){
        this.listener = listener;
    }

    public void setNewCategory(ICategory category){
        this.category = category;
        subCategories.clear();

        //Add new subcategories
        Iterator<String> iterator = category.getSubCategories();
        while(iterator.hasNext()){
            subCategories.add(iterator.next());
        }

        //Only notify if the categories are currently being displayed
        if(recyclerView != null ){
            if(recyclerView.getAdapter() != null){
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentCategoryPickerBinding binding = FragmentCategoryPickerBinding.inflate(inflater);

        //Configure recycler view, currently a vertical list
        recyclerView = binding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecycleViewAdapterCategory(subCategories, this));


        return binding.getRoot();
    }



    @Override
    public void categoryClicked(String categoryName, String subCategoryName) {

        //Send the Category name as well as the subcategory
        listener.categoryClicked(category.getCategoryName(), subCategoryName);
    }
}