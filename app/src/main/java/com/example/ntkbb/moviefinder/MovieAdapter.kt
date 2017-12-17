package com.example.ntkbb.moviefinder

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.github.kimkevin.cachepot.CachePot
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row.view.*
import java.util.*

/**
 * Created by ntkbb on 15/12/2017.
 */
class MovieAdapter: BaseAdapter {

    var context: Context? = null
    var movieList = LinkedList<Movie>()

    constructor(context: Context?, movieList: LinkedList<Movie>) : super() {
        this.context = context
        this.movieList = movieList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val i = LayoutInflater.from(this.context)
        var r = i.inflate(R.layout.row, null)
        var currMovie = this.movieList[position]

        r.date_movie.text = currMovie.release_date
        r.genre_movie.text = currMovie.genre
        r.movieName.text = currMovie.title_en

        Picasso.with(this.context).load(currMovie.poster_ori).into(r.imageView)

        r.setOnClickListener { clickOnRow(currMovie) }

        return r
    }

    override fun getItem(position: Int): Any {
        return movieList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return movieList.size
    }

    fun clickOnRow(movie: Movie){
        Log.d("check","id "+movie.id)
        CachePot.getInstance().push(movie);
        val i = Intent(this.context, MovieDetail::class.java)
        this.context?.startActivity(i)
    }
}