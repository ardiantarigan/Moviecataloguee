package com.wew.moviecatalogues

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowFragment : Fragment() {

    var movies: List<Movie>? = null
    private lateinit var movieAdapter: MovieAdapter

    companion object {
        fun newInstance() = MovieFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movies_list.layoutManager = LinearLayoutManager(activity)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies, object : MovieAdapter.OnAdapterListener {
                override fun onClick(result: Movie) {
                    val intent = Intent(activity, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setupRecyclerView(){
        movieAdapter = MovieAdapter(arrayListOf(), object : MovieAdapter.OnAdapterListener {
            override fun onClick(result: Movie) { val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, result)
                startActivity(intent)
            }
        })
        rv_movies_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }
    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies = response.body()!!.movies

                return callback(response.body()!!.movies)

            }
        })
    }
}