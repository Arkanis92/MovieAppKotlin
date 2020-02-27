package com.example.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.repository.DiscoverRepo
import com.example.movieapp.repository.GenreRepo
//import com.example.movieapp.repository.SearchRepo
import com.example.movieapp.repository.remote.ServiceInstance
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

class MovieViewModel : ViewModel() {

    private val discoverRepository: DiscoverRepo = DiscoverRepo(ServiceInstance.discoverApi)
//    private val searchRepository: SearchRepo = SearchRepo(ServiceInstance.searchApi)
    private val genreRepository: GenreRepo = GenreRepo(ServiceInstance.genreApi)

    val discoverLiveData = liveData(Dispatchers.IO) {
        val discoverData = discoverRepository.getDiscoverMovies()
        emit(discoverData)
    }

//    val searchLiveData = liveData(Dispatchers.IO) {
//        val query = ""
//        val searchData = searchRepository.getSearchList(query)
//        emit(searchData)
//    }

    val genreLiveData = liveData(Dispatchers.IO) {
        val genreData = genreRepository.getGenreList()
        emit(genreData)
    }
}