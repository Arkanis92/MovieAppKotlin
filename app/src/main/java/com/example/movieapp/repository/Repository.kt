package com.example.movieapp.repository

import com.example.movieapp.repository.remote.DiscoverService
import com.example.movieapp.repository.remote.GenreService

//import com.example.movieapp.repository.remote.SearchService

class DiscoverRepo (private val apiInterface: DiscoverService ) {
    suspend fun getDiscoverMovies() = apiInterface.getDiscoverList("popularity.desc")
}

//class SearchRepo (private val apiInterface: SearchService) {
//    suspend fun getSearchList(query: String) = apiInterface.getSearchList(query)
//}

class GenreRepo (private val apiInterface: GenreService) {
    suspend fun getGenreList() = apiInterface.getGenreList()
}