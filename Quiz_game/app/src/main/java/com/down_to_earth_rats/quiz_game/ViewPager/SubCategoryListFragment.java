package com.down_to_earth_rats.quiz_game.ViewPager;

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
 */

public class SubCategoryListFragment extends Fragment implements CategoryClickListener {

    private ICategory category;
    private CategoryClickListener listener;

    private List<String> subCategories = new ArrayList<>();

    private RecyclerView recyclerView;

    public SubCategoryListFragment(){
    }

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


        // Inflate the layout for this fragment
        FragmentCategoryPickerBinding binding = FragmentCategoryPickerBinding.inflate(inflater);
         recyclerView = binding.list;

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(new RecycleViewAdapterCategory(subCategories, this));


        return binding.getRoot();
    }



    @Override
    public void CategoryClicked(String categoryName, String subCategoryName) {
        listener.CategoryClicked(category.getCategoryName(), subCategoryName);
    }
}