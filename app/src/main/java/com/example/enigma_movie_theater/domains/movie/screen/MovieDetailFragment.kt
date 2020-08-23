package com.example.enigma_movie_theater.domains.movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.enigma_movie_theater.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val duration = arguments?.getInt("duration")
        val imageUrl = arguments?.getString("imageUrl")
        val synopsis = arguments?.getString("synopsis")
        val stringDuration = "$duration Min"

        Picasso.get().load(imageUrl).into(movie_cover_detail)
        movie_duration_detail.text = stringDuration
        movie_synopsis_detail.text = synopsis
    }

}