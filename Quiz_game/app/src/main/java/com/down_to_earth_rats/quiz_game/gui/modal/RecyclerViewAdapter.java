package com.down_to_earth_rats.quiz_game.gui.modal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.R;

/**
 * Modified by Carl, Henrik.
 *
 * This class handles recyclerView (used to choose subcategory)
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private String[] mDataset;
    private static IRecyclerViewActivity parent;

    private int layout;

    /**
     * Inner class of RecyclerViewAdapter which represents each unit in the recyclerView.
     * In this case it is a FrameLayout with a TextView.
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView textView;

        /**
         * Sole constructor, creates a FrameLayout with a TextView.
         * @param v parent View
         */
        public MyViewHolder(View v) {
            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = ((TextView) v.findViewById(R.id.textView)).getText().toString();
                    parent.onClickRecyclerViewItem(s);
                }
            });

            textView = v.findViewById(R.id.textView);
        }
    }

    /**
     * Sole constructor, used within the Activities that use a RecyclerView.
     * @param myDataset string array that holds the text on the RecyclerView items
     * @param parent IRecyclerViewActivity object that handles clicks
     * @param layout int describes how many items
     */
    public RecyclerViewAdapter(String[] myDataset, IRecyclerViewActivity parent, int layout) {
        this.parent = parent;
        mDataset = myDataset;
        this.layout = layout;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
