package com.example.enigma_movie_theater.domains.movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Toast
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

        if (convertView != null) {
            val holder = ItemHolder(convertView)
            Picasso.get().load(moviesList[position].image_url).into(holder.movieCover)
            holder.title = moviesList[position].title

            holder.movieCover.setOnClickListener {
                println("${holder.title}. CLICKED")
//            Navigation.findNavController(it)
//                .navigate()
            }
        }

        return view
    }

    class ItemHolder(v: View) {
        var title = ""
        var movieCover: ImageView = v.findViewById(R.id.img_grid_view_movie_cover)
    }

}
