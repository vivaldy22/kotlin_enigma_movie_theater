package com.example.enigma_movie_theater.domains.movie

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(private val movieAPI: MovieAPI) {

    val movies: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movie: MutableLiveData<Movie> = MutableLiveData<Movie>()

    fun getAllMovies() {
        movieAPI.getAllMovies().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movies.value = response.body()
                println("HASIL ${movies.value}")
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    fun getMovieByID(id: String) {
        movieAPI.getMovieByID(id).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                movie.value = response.body()
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    fun createMovie(movie: Movie) {
        movieAPI.createMovie(movie).enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val bodyResponse = response.body()

                if (response.isSuccessful) {
                    println(bodyResponse)
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}