package com.example.enigma_movie_theater.domains.movie

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieAPI {

    @GET("movies")
    fun getAllMovies(): Call<List<Movie>>

    @GET("movie/{id}")
    fun getMovieByID(@Path("id") id: String): Call<Movie>

    @POST("movie")
    fun createMovie(@Body movie: Movie): Call<Movie>

}