package com.down_to_earth_rats.quiz_game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Modified by Carl, Henrik.
 *
 * This class handles recyclerView (used to choose subcategory)
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private String[] mDataset;
    private static IRecyclerViewActivity parent;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView textView;
        //private TextRowItemBinding t;

        public MyViewHolder(View v) {
            super(v);
            //t = TextRowItemBinding.inflate(parent.getLayoutInflater());

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // at the moment it doesn't care what category/subject it is, just starts quiz
                    // how to add viewbinding to fragment?
                    String s = ((TextView) v.findViewById(R.id.textView)).getText().toString();
                    parent.onClickRecyclerViewItem(s);
                }
            });

            textView = (TextView) v.findViewById(R.id.textView);
            //textView = (TextView) t.textView;
        }
    }

    public RecyclerViewAdapter(String[] myDataset, IRecyclerViewActivity parent) {
        this.parent = parent;
        mDataset = myDataset;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.framelayout_recyclerview, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position].toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
