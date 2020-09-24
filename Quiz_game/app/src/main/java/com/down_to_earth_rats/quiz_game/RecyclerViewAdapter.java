package com.down_to_earth_rats.quiz_game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//Carl, Henrik
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private String[] mDataset;
    // this should probably be an interface so we can use recyclerviewadapter on more occasions
    private static IRecyclerViewActivity parent;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        //private TextRowItemBinding t;

        public MyViewHolder(View v) {
            super(v);
            //t = TextRowItemBinding.inflate(parent.getLayoutInflater());

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // at the moment it doesn't care what category/subject it is, just starts quiz
                    String s = ((TextView) v.findViewById(R.id.textView)).getText().toString();
                    parent.handleClick(s);
                }
            });

            // add viewbinding? how??
            textView = (TextView) v.findViewById(R.id.textView);
            //textView = (TextView) t.textView;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(String[] myDataset, SubCategoryActivity parent) {
        this.parent = parent;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.framelayout_recyclerview, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
