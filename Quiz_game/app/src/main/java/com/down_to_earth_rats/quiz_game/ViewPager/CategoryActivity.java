package com.down_to_earth_rats.quiz_game.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.down_to_earth_rats.quiz_game.QuizActivity;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends FragmentActivity implements CategoryClickListener, ViewModelObserver {


    public static String CATEGORY_ID = "category";
    public static String SUBCATEGORY_ID = "sub_category";

    private ViewPager2 viewPager2;

    private CategoryPagerAdapter pagerAdapter;

    private List<ICategory> categoryList = new ArrayList<>();

    private TabLayout tabLayout;
    private CategoryViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(CategoryViewModel.class);
        model.registerObserver(this);
        categoryList = model.getCategories();


        ActivityCategoryPickerBinding binding = ActivityCategoryPickerBinding.inflate(getLayoutInflater());
        viewPager2 = binding.pager;
        pagerAdapter = new CategoryPagerAdapter(this, categoryList, this);
        viewPager2.setAdapter(pagerAdapter);


        tabLayout = binding.tabs;
        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2,
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(model != null){
            model.removeObserver(this);
        }

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
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(CATEGORY_ID, categoryName);
        intent.putExtra(SUBCATEGORY_ID, subCategoryName);

        startActivity(intent);

    }

    @Override
    public void pageUpdated(int position) {
        pagerAdapter.updatePage(position);
        pagerAdapter.notifyDataSetChanged();
    }
}



/*new CountDownTimer(3000, 2000) {

            @Override
            public void onTick(long l) {


            }

            @Override
            public void onFinish() {

                categoryList.remove(2);
                categoryList.add(new ImmutableCategory("Yes", "Coolio", "Awesome", "Nej"));
                //setAdapter();
                //tabLayout.removeTabAt(2);
                //setNewAdapter(2);

                pagerAdapter.updatePage(2);
                pagerAdapter.notifyDataSetChanged();

            }

        }.start();*/

/*private CategoryPickerPagerAdapter test(){
        return new CategoryPickerPagerAdapter(this);
    }*/


//tabLayout.removeTabAt();