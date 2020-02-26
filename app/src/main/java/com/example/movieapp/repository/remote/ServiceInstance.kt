package com.example.movieapp.repository.remote

import com.example.movieapp.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceInstance {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val interceptor = Interceptor { chain ->
        val url = chain.request().url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY).build()
        val request = chain.request().newBuilder().url(url).build()
        chain.proceed(request)
    }


    private val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder().client(apiClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val discoverApi: DiscoverService = retrofit.create(DiscoverService::class.java)

    val searchApi: SearchService = retrofit.create(SearchService::class.java)
}