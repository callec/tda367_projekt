package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Erik Blomberg
 *
 * Used to load the standard Categories.
 * Right now the categories are entered manually
 */

class StandardCategoryHandler implements ICategoryHandler{

    private List<ICategory> categoryList = new ArrayList<>();

    public StandardCategoryHandler() {
        ImmutableCategory category1 = new ImmutableCategory("Matematik", "Addition",
                "Subtraktion", "Multiplikation", "Division");

        ImmutableCategory category2 = new ImmutableCategory("Historia",
                "Svergies Historia", "Världshistoria");

        ImmutableCategory category3 = new ImmutableCategory("Svenska", "Grammatik", "Ord");

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
    }

    @Override
    public Iterator<ICategory> getAllCategories() {
        return new ListIterator<>(categoryList);
    }
}
