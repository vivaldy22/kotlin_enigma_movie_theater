package com.example.enigma_movie_theater.domains.movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.enigma_movie_theater.R
import com.example.enigma_movie_theater.domains.movie.MovieGridAdapter
import com.example.enigma_movie_theater.domains.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_grid.*

class MovieGridFragment : Fragment() {

    private val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.getAllMovies()

        movieViewModel.movies.observe(viewLifecycleOwner, Observer {
            grid_view_movies.adapter = MovieGridAdapter(it)
        })
    }

}