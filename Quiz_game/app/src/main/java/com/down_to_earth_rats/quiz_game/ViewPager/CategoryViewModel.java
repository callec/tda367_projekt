package com.down_to_earth_rats.quiz_game.ViewPager;

import android.os.CountDownTimer;

import androidx.lifecycle.ViewModel;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.CategoryFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategoryHandler;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ImmutableCategory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryViewModel extends ViewModel {

    private List<ICategory> categories = new ArrayList<>();

    private List<ViewModelObserver> observers = new ArrayList<>();

    public CategoryViewModel() {

        getStandardCategories();

        new CountDownTimer(3000, 200){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                categories.remove(1);
                //categories.add(new ImmutableCategory("Test", "Hej", "då", "yellow brick road"));
                notifyObservers(1);
            }
        }.start();
    }

    public void registerObserver(ViewModelObserver observer){
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }
    public void removeObserver(ViewModelObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(int position){
        for(ViewModelObserver observer : observers){
            observer.pageUpdated(position);
        }
    }

    public void getStandardCategories(){
        Iterator<ICategory> iterator = CategoryFactory.getStandardHandler().getAllCategories();
        while(iterator.hasNext()){
            categories.add(iterator.next());
        }
    }

    public List<ICategory> getCategories(){
        return categories;

    }

}
