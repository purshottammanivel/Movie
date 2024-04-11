package com.purshottam.store.movie.domain.use_case

import com.purshottam.store.movie.data.model.toDomainMovie
import com.purshottam.store.movie.domain.model.Movie
import com.purshottam.store.movie.domain.repository.IMovieRepository
import com.purshottam.store.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: IMovieRepository
) {

    operator fun invoke(apiKey: String): Flow<Resource<List<Movie>>> {
        return flow {
            try {
                emit(Resource.Loading())

                val response = movieRepository.getPopularMovies(apiKey)
                val list =
                    if (response.results.isNullOrEmpty()) emptyList<Movie>()
                    else response.results.map { it.toDomainMovie() }

                emit(Resource.Success(data = list))

            } catch (e: HttpException) {

                emit(Resource.Error(message = e.localizedMessage ?: "HttpException"))

            } catch (e: IOException) {

                emit(Resource.Error(message = e.localizedMessage ?: "IOException"))

            } catch (e: Exception) {

                emit(Resource.Error(message = e.localizedMessage ?: "Exception"))

            }
        }
    }
}