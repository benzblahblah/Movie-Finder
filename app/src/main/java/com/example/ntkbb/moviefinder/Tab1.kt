package com.example.ntkbb.moviefinder

//import android.app.Fragment
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.tab_allmovies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

/**
 * Created by ntkbb on 14/12/2017.
 */
class Tab1 : Fragment() {

    var movieList = LinkedList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //showListOfMovies()
        return inflater.inflate(R.layout.tab_allmovies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showListOfMovies()
    }

    fun showListOfMovies(){

        var r = Retrofit.Builder()
                .baseUrl( "http://www.majorcineplex.com/apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        r.create(MovieService::class.java).getMovies().enqueue(object: Callback<Result>{
            override fun onResponse(call: Call<Result>?, response: Response<Result>?) {
                val result = response?.body() ?: Result()
                val movies = result?.movies

                if (movies != null) {
                    for (m in movies) {
                        movieList.add(Movie(m.id, "http://www.majorcineplex.com" + m.poster_ori,
                                m.title_en, m.genre, m.release_date, m.synopsis_en))
                    }

                    ListMovie.adapter = MovieAdapter(getActivity(), movieList)
                }

            }

            override fun onFailure(call: Call<Result>?, t: Throwable?) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show()
            }

        })

    }


}