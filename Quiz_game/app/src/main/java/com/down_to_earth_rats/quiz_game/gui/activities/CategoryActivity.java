package com.down_to_earth_rats.quiz_game.gui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.down_to_earth_rats.quiz_game.gui.category_picker.ICategoryClickListener;
import com.down_to_earth_rats.quiz_game.gui.category_picker.CategoryPagerAdapter;
import com.down_to_earth_rats.quiz_game.category.CategoryModel;
import com.down_to_earth_rats.quiz_game.category.IModelObserver;
import com.down_to_earth_rats.quiz_game.category.ICategory;
import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Blomberg
 * Modified by Erik Blomberg, Henrik Johansson and Louise Tranborg
 *
 * This is the activity used to display all categories and their respective subcategories.
 * The activity stores two values into SharedPreferences, the Category name and Subcategory name
 */
public class CategoryActivity extends AppCompatActivity implements ICategoryClickListener, IModelObserver {

    //Keys used to access the correct data from SharedPreferences
    public static String CATEGORY_NAME = "category";
    public static String SUBCATEGORY_NAME = "sub_category";

    private CategoryModel model;

    private ViewPager2 viewPager;
    private CategoryPagerAdapter pagerAdapter;

    private List<ICategory> categoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get categories
        model = new ViewModelProvider(this).get(CategoryModel.class);
        model.registerObserver(this);
        categoryList = model.getCategories();

        ActivityCategoryPickerBinding binding = ActivityCategoryPickerBinding.inflate(getLayoutInflater());

        //Set PagerAdapter
        viewPager = binding.pager;
        pagerAdapter = new CategoryPagerAdapter(this, categoryList, this);
        viewPager.setAdapter(pagerAdapter);

        //Configure tabs
        TabLayout tabLayout = binding.tabs;
        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText((categoryList.get(position).getCategoryName()));

                    }
                }
        );
        tabLayoutMediator.attach();


        setUpToolbar(binding.toolbarCategory);

        setContentView(binding.getRoot());

    }

    private void setUpToolbar(Toolbar toolbar){

        toolbar.setTitle("Välj ämne");
        setSupportActionBar(toolbar);

        //Enable back button
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void pageUpdated(int position) {

        //Update subcategories
        pagerAdapter.updatePage(position);

        //Update tabs
        pagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void categoryClicked(String categoryName, String subCategoryName) {

        //Save current category and sub category via shared preferences
        SharedPreferences pref = this.getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(CATEGORY_NAME, categoryName);
        editor.putString(SUBCATEGORY_NAME, subCategoryName);
        editor.apply();

        //Launch the game
        Intent intent = new Intent(this, QuizActivity.class);

        startActivity(intent);

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
        //Step backwards in the ViewPager
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}