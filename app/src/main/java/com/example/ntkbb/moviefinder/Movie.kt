package com.example.ntkbb.moviefinder

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by ntkbb on 15/12/2017.
 */

data class Result(
        var movies: LinkedList<Movie> = LinkedList()
)

data class Movie(
        var id: Int = 0,
        var poster_ori: String = "",
        var title_en: String = "",
        var genre: String = "",
        var release_date: String = "",
        var synopsis_en: String = ""
)