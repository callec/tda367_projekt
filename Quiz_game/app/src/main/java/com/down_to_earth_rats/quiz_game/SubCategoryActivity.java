package com.down_to_earth_rats.quiz_game;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.databinding.ActivitySubCategoryBinding;

/**
 * Class created by Erik and Louise
 *
 * Modified by Carl and Henrik
 *
 * This class represents the view of the choosing of subCategory, ex. Addition.
 */
public class SubCategoryActivity extends AppCompatActivity implements IRecyclerViewActivity {

    private ActivitySubCategoryBinding viewBinding;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Subcategory[] subcategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivitySubCategoryBinding.inflate(getLayoutInflater());

        //Configure toolbar
        Toolbar toolbar = viewBinding.toolbarSubCategory;
        toolbar.setTitle(R.string.category_title);
        setSupportActionBar(toolbar);

        //Added by Louise to be able to go back to SubjectActivity (The arrow in the right left corner).
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        /*viewBinding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });*/

        this.subcategories = new Subcategory[]{Subcategory.Addition, Subcategory.Subtraktion, Subcategory.Multiplikation, Subcategory.Division};

        setContentView(viewBinding.getRoot());

        recyclerView = viewBinding.recyclerView;

        //REMOVE IF NEED TO CHANGE SIZE DURING RUNTIME
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter≤
        mAdapter = new RecyclerViewAdapter(subcategories, this);
        recyclerView.setAdapter(mAdapter);
    }

    //@Override
    public void onClickRecyclerViewItem(Subcategory s){
        switch(s) {
            case Addition:
                Intent intent = new Intent(this, QuizActivity.class);
                startActivity(intent);
                break;
            default:
                // do nothing, subcategory doesn't exist.
        }
    }
}