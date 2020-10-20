package com.down_to_earth_rats.quiz_game.category;

import com.down_to_earth_rats.quiz_game.utility.ListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Category which can store "unlimited" amount of Subcategories, but cannot change.
 */

public class ImmutableCategory implements ICategory {

    private String name;

    private List<String> subCategoriesList = new ArrayList<>();

    public ImmutableCategory(String name, String... subCategories) {
        this.name = name;
        subCategoriesList.addAll(Arrays.asList(subCategories));
    }

    @Override
    public String getCategoryName() {
        return name;
    }

    @Override
    public Iterator<String> getSubCategories() {

        return new ListIterator<>(subCategoriesList);
    }
}
