package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import java.util.Iterator;

/**
 * Created by Erik Blomberg
 *
 */

public interface ICategory {

    String getCategoryName();

    Iterator<String> getSubCategories();


}
