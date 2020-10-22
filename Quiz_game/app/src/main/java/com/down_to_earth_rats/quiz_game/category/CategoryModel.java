package com.down_to_earth_rats.quiz_game.category;

import androidx.lifecycle.ViewModel;

import com.down_to_earth_rats.quiz_game.user.UserSingleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Model for displaying available categories to choose from.
 * Currently, only the default categories and User Categories are present.
 * Inherits the ViewModel class, data is not lost during configuration changes
 */

public class CategoryModel extends ViewModel {

    private final List<ICategory> categories = new ArrayList<>();

    private final List<IModelObserver> observers = new ArrayList<>();

    public CategoryModel() {
        getDefaultCategories();
        //User categories
        categories.add(UserSingleton.getUser().getUserCategory());

    }


    private void getDefaultCategories(){
        Iterator<ICategory> iterator = CategoryFactory.getDefaultHandler().getAllCategories();
        while(iterator.hasNext()){
            categories.add(iterator.next());
        }
    }

    public List<ICategory> getCategories(){
        return categories;
    }

    public void registerObserver(IModelObserver observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(IModelObserver observer){
        observers.remove(observer);
    }

    //Notify which category has been updated
    private void notifyObservers(int position){
        for(IModelObserver observer : observers){
            observer.pageUpdated(position);
        }
    }

}