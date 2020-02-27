package com.example.movieapp.repository.remote

import com.example.movieapp.model.genre.GenreResponse
import retrofit2.http.GET

interface GenreService {
    @GET("genre/movie/list")
    suspend fun getGenreList(
    ): GenreResponse
}