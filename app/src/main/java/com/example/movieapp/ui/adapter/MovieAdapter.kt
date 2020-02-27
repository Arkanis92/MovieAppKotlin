package com.example.movieapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.discover.ResultsItem
import com.example.movieapp.model.genre.GenresItem
import kotlinx.android.synthetic.main.discover_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class MovieAdapter(private var results: ArrayList<ResultsItem>, private val genres: ArrayList<GenresItem>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.discover_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.loadDiscoverData(results[position])
    }

    private fun associateGenreId(genreId: Int) {

    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun loadDiscoverData(result: ResultsItem) {
            itemView.apply {
                tvTitle.text = result.title
                tvPopularity.text = String.format(Locale.getDefault(), "%.2f", result.popularity)
            }
        }
    }
}