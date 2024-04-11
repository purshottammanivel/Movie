package com.purshottam.store.movie.domain.repository

import com.purshottam.store.movie.data.model.MoviesDto

interface IMovieRepository {

    suspend fun getPopularMovies(apiKey: String): MoviesDto
}