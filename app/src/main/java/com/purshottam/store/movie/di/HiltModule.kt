package com.purshottam.store.movie.di

import com.purshottam.store.movie.data.remote.IMovieApi
import com.purshottam.store.movie.data.repository.MovieRepositoryImpl
import com.purshottam.store.movie.domain.repository.IMovieRepository
import com.purshottam.store.utility.CONSTANTS.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideMovieApi(): IMovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMovieApi::class.java)
    }

    @Provides
    fun provideMovieRepository(movieApi: IMovieApi): IMovieRepository {
        return MovieRepositoryImpl(movieApi)
    }
}