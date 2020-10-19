package com.down_to_earth_rats.quiz_game.GUIPackage.Modal;

/**
 * Created by Carl and Henrik
 *
 * This class is used to loosen the dependency between the RecyclerViewAdapter and the classes that use it.
 */
public interface IRecyclerViewActivity {

    /**
     * Handles click on each specific FrameLayout in a RecyclerView.
     * @param selectedItem string of what is selected from the RecyclerView
     */
    void onClickRecyclerViewItem(String selectedItem);
}
