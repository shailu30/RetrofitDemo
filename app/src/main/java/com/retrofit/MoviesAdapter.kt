package com.retrofit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class MoviesAdapter internal constructor(private val movies: List<Movie>, private val rowLayout: Int) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MoviesAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        holder.data.text = movies[position].releaseDate
        holder.movieDescription.text = movies[position].overview
        holder.rating.text = movies[position].voteAverage!!.toString()
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var moviesLayout: LinearLayout = v.findViewById(R.id.movies_layout)
        var movieTitle: TextView = v.findViewById(R.id.title)
        var data: TextView = v.findViewById(R.id.subtitle)
        var movieDescription: TextView = v.findViewById(R.id.description)
        var rating: TextView = v.findViewById(R.id.rating)
    }
}