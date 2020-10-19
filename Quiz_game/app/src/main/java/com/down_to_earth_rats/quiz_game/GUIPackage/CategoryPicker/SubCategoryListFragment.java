package com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.databinding.FragmentCategoryPickerBinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Fragment displaying a list with subcategories from a specific category
 */

public class SubCategoryListFragment extends Fragment implements CategoryClickListener {

    private CategoryClickListener listener;

    private ICategory category;
    private List<String> subCategories = new ArrayList<>();

    private RecyclerView recyclerView;


    public void setListener(CategoryClickListener listener){
        this.listener = listener;
    }

    public void setNewCategory(ICategory category){
        this.category = category;
        subCategories.clear();

        Iterator<String> iterator = category.getSubCategories();
        while(iterator.hasNext()){
            subCategories.add(iterator.next());
        }

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

        //Configure recycler view
        recyclerView = binding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecycleViewAdapterCategory(subCategories, this));


        return binding.getRoot();
    }



    @Override
    public void categoryClicked(String categoryName, String subCategoryName) {
        listener.categoryClicked(category.getCategoryName(), subCategoryName);
    }
}