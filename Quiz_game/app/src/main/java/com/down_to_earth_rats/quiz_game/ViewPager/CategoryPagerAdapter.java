package com.down_to_earth_rats.quiz_game.ViewPager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 */

public class CategoryPagerAdapter extends FragmentStateAdapter {

    private List<ICategory> dataSet = new ArrayList<>();
    private CategoryClickListener listener;

    private List<SubCategoryListFragment> fragments = new ArrayList<>();


    public CategoryPagerAdapter(FragmentActivity fa, List<ICategory> dataSet, CategoryClickListener listener) {
        super(fa);

        this.listener = listener;
        this.dataSet = dataSet;
    }

    @Override
    public Fragment createFragment(int position) {

        SubCategoryListFragment fragment = new SubCategoryListFragment();
        fragment.setNewCategory(dataSet.get(position));
        fragment.setListener(listener);

        fragments.add(position, fragment);

        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updatePage(int position){
        if(fragments.size() > position && dataSet.size() > position){
            fragments.get(position).setNewCategory(dataSet.get(position));
        }
    }


}
