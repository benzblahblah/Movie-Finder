package com.example.ntkbb.moviefinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.kimkevin.cachepot.CachePot
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_detail.*
import kotlinx.android.synthetic.main.row.*
import kotlinx.android.synthetic.main.row.view.*


class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        val Movie = CachePot.getInstance().pop<Movie>(Movie::class.java)

        captionD.text = Movie.synopsis_en
        DateD.text = Movie.release_date
        movieNameD.text = Movie.title_en
        GenreD.text = Movie.genre
        Picasso.with(applicationContext).load(Movie.poster_ori).into(imageView2)
    }
}
