package com.purshottam.store.movie.data.remote

import com.purshottam.store.movie.data.model.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieApi {

    @GET("popular?")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MoviesDto
}