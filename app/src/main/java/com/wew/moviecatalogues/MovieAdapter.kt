package com.wew.moviecatalogues

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wew.moviecatalogues.R
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies : List<Movie>, val listener: OnAdapterListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindMovie(movie : Movie){
            itemView.movie_title.text = movie.title
            itemView.popularity.text = movie.popularity
            itemView.original_language.text = movie.original_language
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
            Log.e("MovieAdapter","URL Image ==> $IMAGE_BASE${movie.poster}")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
        holder.itemView.setOnClickListener { listener.onClick(movies[position]) }
    }

    interface OnAdapterListener {
        fun onClick(result: Movie)
    }

}
