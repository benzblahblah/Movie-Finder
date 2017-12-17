package com.example.ntkbb.moviefinder

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ntkbb on 15/12/2017.
 */
interface MovieService {

    @GET("get_movie_avaiable")
    fun getMovies(): Call<Result>

}