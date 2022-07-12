package com.wew.moviecatalogues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.wew.moviecatalogues.R
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    var movies: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        movies = intent.getParcelableExtra(EXTRA_DATA)

        tv_title.text = movies?.title
        overview.text = movies?.overview
        popularity.text = movies?.popularity
        original_language.text = movies?.original_language
        vote.text = movies?.vote
        release_date.text = movies?.release
        Glide.with(img_poster).load(IMAGE_BASE + movies!!.poster).into(img_poster)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}