package com.example.enigma_movie_theater.domains.movie.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigma_movie_theater.R
import com.example.enigma_movie_theater.domains.movie.Movie
import com.example.enigma_movie_theater.domains.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_add.*

class MovieAddFragment : Fragment() {

    private val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_movie_button.setOnClickListener {
            val title = movie_title_input.text.toString()
            val duration = movie_duration_input.text.toString()
            val imageUrl = movie_image_url_input.text.toString()
            val synopsis = movie_synopsis_input.text.toString()

            if (title.isEmpty() || duration.isEmpty() || imageUrl.isEmpty() || synopsis.isEmpty()) {
                Toast.makeText(activity, "All field must be filled!", Toast.LENGTH_SHORT).show()
            } else {
                movieViewModel.createMovie(Movie(title = title, duration = duration.toInt(), image_url = imageUrl, synopsis = synopsis))
                Navigation.findNavController(view).navigate(R.id.action_movieAddFragment_pop)
            }
        }
    }

}