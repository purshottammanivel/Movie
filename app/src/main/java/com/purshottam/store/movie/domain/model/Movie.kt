package com.purshottam.store.movie.domain.model

data class Movie(
    val adult: Boolean = false,
    val backdropPath: String,
    val genreIds: List<Int>?,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean = false,
    val voteAverage: Double,
    val voteCount: Int
)