package com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.down_to_earth_rats.quiz_game.Category.ICategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * Used to display a fragment on each page in the ViewPager
 */

public class CategoryPagerAdapter extends FragmentStateAdapter {

    private List<ICategory> dataSet;
    private ICategoryClickListener listener;

    private List<SubCategoryListFragment> fragments = new ArrayList<>();


    public CategoryPagerAdapter(FragmentActivity fa, List<ICategory> dataSet, ICategoryClickListener listener) {
        super(fa);

        this.listener = listener;
        this.dataSet = dataSet;
    }

    @Override
    public Fragment createFragment(int position) {

        SubCategoryListFragment fragment = new SubCategoryListFragment();
        fragment.setNewCategory(dataSet.get(position));
        fragment.setListener(listener);

        //Store fragment for later reference
        fragments.add(position, fragment);

        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void updatePage(int position){
        //Confirm that the page can be found
        if(fragments.size() > position && dataSet.size() > position){
            fragments.get(position).setNewCategory(dataSet.get(position));
        }
    }
}
