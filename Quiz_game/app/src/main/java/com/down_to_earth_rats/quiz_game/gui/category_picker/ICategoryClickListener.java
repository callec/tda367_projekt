package com.down_to_earth_rats.quiz_game.gui.category_picker;

/**
 * Created by Erik Blomberg
 *
 * Used to listen for when a Category has been selected
 */

public interface ICategoryClickListener {

    void categoryClicked(String categoryName, String subCategoryName);

}
