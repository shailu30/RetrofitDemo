package com.retrofit;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by zoomi on 01-Nov-17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

  private List<Movie> movies;

  private int rowLayout;

  MoviesAdapter(List<Movie> movies, int rowLayout) {
    this.movies = movies;
    this.rowLayout = rowLayout;
  }

  @Override
  public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
    return new MovieViewHolder(view);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(MovieViewHolder holder, final int position) {
    holder.movieTitle.setText(movies.get(position).getTitle());
    holder.data.setText(movies.get(position).getReleaseDate());
    holder.movieDescription.setText(movies.get(position).getOverview());
    holder.rating.setText(movies.get(position).getVoteAverage().toString());
  }

  @Override
  public int getItemCount() {
    return movies.size();
  }

  static class MovieViewHolder extends RecyclerView.ViewHolder {

    LinearLayout moviesLayout;
    TextView movieTitle;
    TextView data;
    TextView movieDescription;
    TextView rating;

    MovieViewHolder(View v) {
      super(v);
      moviesLayout = v.findViewById(R.id.movies_layout);
      movieTitle = v.findViewById(R.id.title);
      data = v.findViewById(R.id.subtitle);
      movieDescription = v.findViewById(R.id.description);
      rating = v.findViewById(R.id.rating);
    }
  }
}