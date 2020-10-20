package com.down_to_earth_rats.quiz_game.Category;

import com.down_to_earth_rats.quiz_game.Utility.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Erik Blomberg
 *
 * Used to load the standard Categories.
 * Right now the categories are entered manually
 */

class SimpleCategoryHandler implements ICategoryHandler{

    private List<ICategory> categoryList = new ArrayList<>();

    public SimpleCategoryHandler() {  //TODO byta till strings från R.strings ?
        ImmutableCategory category1 = new ImmutableCategory("Matematik", "Addition",
                "Subtraktion", "Multiplikation", "Division");

        ImmutableCategory category2 = new ImmutableCategory("Historia",
                "Sveriges Historia", "Europas Historia");

        //ImmutableCategory category3 = new ImmutableCategory("Svenska", "Grammatik", "Ord");

        categoryList.add(category1);
        categoryList.add(category2);
        //categoryList.add(category3);
    }

    @Override
    public Iterator<ICategory> getAllCategories() {
        return new ListIterator<>(categoryList);
    }
}
