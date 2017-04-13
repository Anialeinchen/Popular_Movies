package com.annamorgiel.popular_movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Anna Morgiel on 13.04.2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private static final String TAG = MovieAdapter.class.getSimpleName();

    final private GridItemClickListener mOnClickListener;

    private static int viewHolderCount;

    private int mNumberItems;

    public interface GridItemClickListener {
        void onGridItemClick(int clickedItemIndex);
    }
    public MovieAdapter(int numberOfItems, GridItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForGridItem = R.layout.grid_item_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmidiately = false;
        View view = inflater.inflate(layoutIdForGridItem,parent, shouldAttachToParentImmidiately);
        MovieViewHolder holder = new MovieViewHolder(view);
        holder.ind

    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView gridItemPosterView;


        public MovieViewHolder(View itemView) {
            super(itemView);

        gridItemPosterView = (ImageView) itemView.findViewById(R.id.poster_iv);

        // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
        itemView.setOnClickListener(this);
        }

// TODO: 13.04.2017
        void bind(int listIndex) {
            gridItemPosterView.setImageDrawable();}


        // COMPLETED (6) Override onClick, passing the clicked item's position (getAdapterPosition()) to mOnClickListener via its onListItemClick method
        /**
         * Called whenever a user clicks on an item in the list.
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onGridItemClick(clickedPosition);
        }
    }
}
