package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import java.util.Iterator;

public interface ICategory {

    String getCategoryName();

    Iterator<String> getSubCategories();


}
