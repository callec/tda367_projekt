package com.down_to_earth_rats.quiz_game.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.down_to_earth_rats.quiz_game.QuizPackage.Category.CategoryFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryPickerActivity extends FragmentActivity implements CategoryListener {

    private int NUM = 3;

    private ViewPager2 viewPager2;

    private FragmentStateAdapter pagerAdapter;

    private List<ICategory> categoryList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Iterator<ICategory> categoryIterator = CategoryFactory.getStandardHandler().getAllCategories();

        while(categoryIterator.hasNext()){
            categoryList.add(categoryIterator.next());
        }


        ActivityCategoryPickerBinding binding = ActivityCategoryPickerBinding.inflate(getLayoutInflater());
        viewPager2 = binding.pager;
        pagerAdapter = new CategoryPickerPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        TabLayout tabLayout = binding.tabs;
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText((categoryList.get(position).getCategoryName()));

                    }
                }
        );
        tabLayoutMediator.attach();

        setContentView(binding.getRoot());

    }

    public Fragment createFragment(int position){
        return new CategoryPickerFragment(categoryList.get(position), this);
    }

    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {

            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }

    @Override
    public void CategoryClicked(String categoryName, String subCategoryName) {
        System.out.println("CName: " + categoryName + "  SCName: " + subCategoryName);

    }


    private class CategoryPickerPagerAdapter extends FragmentStateAdapter {

        public CategoryPickerPagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return CategoryPickerActivity.this.createFragment(position);
        }

        @Override
        public int getItemCount() {
            return categoryList.size();
        }
    }


}



/*new CountDownTimer(3000, 2000) {

            @Override
            public void onTick(long l) {


            }

            @Override
            public void onFinish() {

                NUM--;
                pagerAdapter = test();
                viewPager2.setAdapter(pagerAdapter);
                pagerAdapter.notifyDataSetChanged();
            }

        }.start();*/


/*private CategoryPickerPagerAdapter test(){
        return new CategoryPickerPagerAdapter(this);
    }*/


//tabLayout.removeTabAt();