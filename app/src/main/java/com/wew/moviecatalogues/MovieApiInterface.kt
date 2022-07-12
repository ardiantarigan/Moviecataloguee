package com.wew.moviecatalogues

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/upcoming?api_key=6c34cda0a72ce9d11ba149a47ebd489c")
    fun getMovieList(): Call<MovieResponse>
}