package com.example.movieapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.movieapp.R
import com.example.movieapp.model.discover.DiscoverResponse
import com.example.movieapp.model.discover.ResultsItem
import com.example.movieapp.model.genre.GenresItem
import com.example.movieapp.ui.adapter.MovieAdapter
import com.example.movieapp.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_discover.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class DiscoverFragment : Fragment() {

    private var movieAdapter: MovieAdapter? = null
    private val movieViewModel: MovieViewModel by viewModels()
    private val discoverResultsList = ArrayList<ResultsItem>()
    private val genreResultsList = ArrayList<GenresItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        movieAdapter?.apply { notifyDataSetChanged() } ?:run {
            movieAdapter = MovieAdapter(discoverResultsList, genreResultsList)
            with(rvDiscoverView) {
                layoutManager = LinearLayoutManager(context)
                adapter = movieAdapter
                itemAnimator = DefaultItemAnimator()
            }
        }
    }

    private fun setupObservers() {
        movieViewModel.discoverLiveData.observe(viewLifecycleOwner) {
            it.results?.filterNotNull()?.let {itemList ->
                discoverResultsList.addAll(itemList).also {
                    movieAdapter?.notifyDataSetChanged()
                }
            }
        }
        movieViewModel.genreLiveData.observe(viewLifecycleOwner) {
            it.genres?.filterNotNull()?.let { itemList ->
                genreResultsList.addAll(itemList).also {
                    movieAdapter?.notifyDataSetChanged()
                }
            }
        }
    }
}
