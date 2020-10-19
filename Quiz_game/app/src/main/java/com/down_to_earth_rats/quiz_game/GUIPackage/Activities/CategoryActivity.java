package com.down_to_earth_rats.quiz_game.GUIPackage.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker.CategoryClickListener;
import com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker.CategoryPagerAdapter;
import com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker.CategoryViewModel;
import com.down_to_earth_rats.quiz_game.GUIPackage.CategoryPicker.ViewModelObserver;
import com.down_to_earth_rats.quiz_game.QuizPackage.Category.ICategory;
import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityCategoryPickerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 * This is the activity used to display all categories and their respective subcategories.
 * The activity sends to values, the category name and the subcategory name.
 */
//Changed from FragmentActivity, maybe something will go wrong!
public class CategoryActivity extends AppCompatActivity implements CategoryClickListener, ViewModelObserver {

    //Use these in combination with Intent.getExtra()
    public static String CATEGORY_NAME = "category";
    public static String SUBCATEGORY_NAME = "sub_category";

    private CategoryViewModel model;

    private ViewPager2 viewPager;
    private CategoryPagerAdapter pagerAdapter;

    private List<ICategory> categoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get categories
        model = new ViewModelProvider(this).get(CategoryViewModel.class);
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
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}