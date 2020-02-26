package com.example.movieapp.repository.remote

import com.example.movieapp.model.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("/search/movie")
    suspend fun getSearchList(
        @Query ("query") query: String
    ): SearchResponse
}