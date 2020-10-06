package com.down_to_earth_rats.quiz_game.ViewPager;

import androidx.lifecycle.ViewModel;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.CategoryFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategoryHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryViewModel extends ViewModel {

    private List<ICategory> categories = new ArrayList<>();

    public CategoryViewModel() {

        getStandardCategories();
    }

    void getStandardCategories(){
        Iterator<ICategory> iterator = CategoryFactory.getStandardHandler().getAllCategories();
        while(iterator.hasNext()){
            categories.add(iterator.next());
        }
    }

    public List<ICategory> getCategories(){
        return categories;

    }

}
