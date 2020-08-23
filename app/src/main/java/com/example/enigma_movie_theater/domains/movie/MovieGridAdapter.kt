package com.example.enigma_movie_theater.domains.movie

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.enigma_movie_theater.R
import com.squareup.picasso.Picasso


class MovieGridAdapter(private val moviesList: List<Movie>, private val context: Context? = null) : BaseAdapter() {

    override fun getCount(): Int {
        return moviesList.size
    }

    override fun getItem(position: Int): Any {
        return moviesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_layout_movie, null)
        val movieCover = view.findViewById<ImageView>(R.id.img_grid_view_movie_cover)

        Picasso.get().load(moviesList[position].image_url).into(movieCover)

        movieCover.setOnClickListener {
            val item = moviesList[position]
            val bundle = Bundle()
            bundle.putString("imageUrl", item.image_url)
            bundle.putInt("duration", item.duration)
            bundle.putString("synopsis", item.synopsis)

            Navigation.findNavController(it)
                .navigate(R.id.action_to_fragment_movie_detail, bundle)
        }

        return view!!
    }

}

class ItemHolder(v: View) {

    var title = ""
    var movieCover: ImageView = v.findViewById(R.id.img_grid_view_movie_cover)

}
