package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.ListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class StandardCategoryHandler implements ICategoryHandler{


    private List<ICategory> categoryList = new ArrayList<>();


    public StandardCategoryHandler() {
        ImmutableCategory category1 = new ImmutableCategory("Matematik", "Addition",
                "Subtraktion", "Multiplikation", "Division");
        categoryList.add(category1);
        ImmutableCategory category2 = new ImmutableCategory("Historia", "Årtal", "Kungar");
        categoryList.add(category2);
        ImmutableCategory category3 = new ImmutableCategory("Svenska", "Grammatik", "Ord");
        categoryList.add(category3);
    }




    @Override
    public Iterator<ICategory> getAllCategories() {
        return new ListIterator<>(categoryList);
    }
}
