package com.purshottam.store.movie.data.repository

import com.purshottam.store.movie.data.model.MoviesDto
import com.purshottam.store.movie.data.remote.IMovieApi
import com.purshottam.store.movie.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: IMovieApi
) : IMovieRepository {

    override suspend fun getPopularMovies(apiKey: String): MoviesDto {
        return movieApi.getPopularMovies(apiKey)
    }
}