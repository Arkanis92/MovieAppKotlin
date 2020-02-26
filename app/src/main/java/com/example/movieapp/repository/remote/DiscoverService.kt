package com.example.movieapp.repository.remote

import com.example.movieapp.model.discover.DiscoverResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {
    @GET("/discover/movie")
    suspend fun getDiscoverList(
        @Query ("sort_by") sort_by: String
    ): DiscoverResponse
}