package com.down_to_earth_rats.quiz_game.category;

import com.down_to_earth_rats.quiz_game.utility.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Used to load the default Categories.
 * Right now the categories are entered manually and are static
 * Implements the ICategoryHandler to have uniform way to access the categories.
 */

class DefaultCategoryHandler implements ICategoryHandler{

    private List<ICategory> categoryList = new ArrayList<>();

    public DefaultCategoryHandler() {
        ImmutableCategory category1 = new ImmutableCategory("Matematik", "Addition",
                "Subtraktion", "Multiplikation", "Division");

        ImmutableCategory category2 = new ImmutableCategory("Historia",
                "Sveriges Historia", "Europas Historia");



        categoryList.add(category1);
        categoryList.add(category2);

    }

    @Override
    public Iterator<ICategory> getAllCategories() {
        return new ListIterator<>(categoryList);
    }
}
