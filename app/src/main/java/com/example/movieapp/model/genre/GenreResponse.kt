package com.example.movieapp.model.genre


import com.squareup.moshi.Json


data class GenreResponse(

    @Json(name = "genres")
    val genres: List<GenresItem?>? = null
)