package com.example.ntkbb.moviefinder

import android.support.v4.app.Fragment
//import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tab_favorite.*
import java.util.*

/**
 * Created by ntkbb on 14/12/2017.
 */
class Tab2 : Fragment() {

    var favMovieList = LinkedList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.tab_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        ListFavMovie.adapter = MovieAdapter(getActivity(), favMovieList)
    }
}