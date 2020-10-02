package com.down_to_earth_rats.quiz_game;


//Carl, Henrik

/**
 * Created by Carl and Henrik
 *
 * This class is used to loosen the dependency between the RecyclerViewAdapter and the classes that use it.
 */
public interface IRecyclerViewActivity {

    void onClickRecyclerViewItem(Subcategory subcategory);
}
