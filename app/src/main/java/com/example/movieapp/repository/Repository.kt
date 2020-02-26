package com.example.movieapp.repository

import com.example.movieapp.repository.remote.DiscoverService
import com.example.movieapp.repository.remote.SearchService
import com.example.movieapp.repository.remote.ServiceInstance
import retrofit2.Retrofit
import retrofit2.http.Query

class DiscoverRepo (private val apiInterface: DiscoverService ) {
    suspend fun getDiscoverMovies() = apiInterface.getDiscoverList("popularity.desc")
}

class SearchRepo (private val apiInterface: SearchService) {
    suspend fun getSearchList(query: String) = apiInterface.getSearchList(query)
}