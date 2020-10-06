package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

public abstract class CategoryFactory {

    private static ICategoryHandler instanceHandler;

    public static ICategoryHandler getStandardHandler(){
        if(instanceHandler == null){
            instanceHandler = new StandardCategoryHandler();
        }
        return instanceHandler;
    }

}
