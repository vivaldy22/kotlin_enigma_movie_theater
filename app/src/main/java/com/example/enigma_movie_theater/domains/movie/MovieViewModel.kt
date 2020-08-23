package com.example.enigma_movie_theater.domains.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigma_movie_theater.config.RetrofitBuilder

class MovieViewModel : ViewModel() {

    private val movieRepo: MovieRepository

    init {
        val movieAPI = RetrofitBuilder.createRetrofit().create(MovieAPI::class.java)
        movieRepo = MovieRepository(movieAPI)
    }

    val movies: LiveData<List<Movie>> = movieRepo.movies
    val movie: LiveData<Movie> = movieRepo.movie

    fun getAllMovies() {
        movieRepo.getAllMovies()
    }

    fun getMovieByID(id: String) {
        movieRepo.getMovieByID(id)
    }

    fun createMovie(movie: Movie) {
        movieRepo.createMovie(movie)
    }

}