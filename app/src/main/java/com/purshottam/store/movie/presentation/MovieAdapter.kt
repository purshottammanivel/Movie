package com.purshottam.store.movie.presentation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.purshottam.store.databinding.MovieLayoutBinding
import com.purshottam.store.movie.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList = ArrayList<Movie>()

    fun setMovieList(movieList: List<Movie>) {
        this.movieList = movieList as ArrayList<Movie>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].posterPath)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}