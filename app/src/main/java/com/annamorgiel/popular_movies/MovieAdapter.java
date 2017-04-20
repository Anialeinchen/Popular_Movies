package com.annamorgiel.popular_movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.annamorgiel.popular_movies.rest.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Anna Morgiel on 13.04.2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private static final String TAG = MovieAdapter.class.getSimpleName();

    final private GridItemClickListener mOnClickListener;

    String moviePosterPath;

    private List<Movie> movieList;

    String url = "http://image.tmdb.org/t/p/w185/";


    public interface GridItemClickListener {
        void onGridItemClick(int clickedItemIndex);
    }


    public MovieAdapter(int numberOfItems, GridItemClickListener listener) {
        movieList = new List<Movie>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Movie> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Movie movie) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Movie> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Movie> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Movie get(int i) {
                return null;
            }

            @Override
            public Movie set(int i, Movie movie) {
                return null;
            }

            @Override
            public void add(int i, Movie movie) {

            }

            @Override
            public Movie remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Movie> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Movie> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Movie> subList(int i, int i1) {
                return null;
            }
        };
        mOnClickListener = listener;
    }

    public void setMovieList(List<Movie> movies){
        movieList = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForGridItem = R.layout.grid_item_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmidiately = false;
        View view = inflater.inflate(layoutIdForGridItem,parent, shouldAttachToParentImmidiately);
        MovieViewHolder holder = new MovieViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        ImageView gridItemPosterView;
        gridItemPosterView = (ImageView) holder.itemView.findViewById(R.id.poster_iv);
        Movie movie = movieList.get(position);
        moviePosterPath = movie.getPosterPath();
        Picasso.with(holder.getContext()).load(url + moviePosterPath).into(gridItemPosterView);
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public Context getContext() {
            return context;
        }

        Context context = getContext() ;

        public MovieViewHolder(View itemView) {
            super(itemView);


        // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
        itemView.setOnClickListener(this);
        }

        // TODO: 13.04.2017
       // void bind(int listIndex) {
         //   Picasso.with(context).load(url).into(gridItemPosterView);}

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onGridItemClick(clickedPosition);
        }
    }
}