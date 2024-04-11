package com.purshottam.store.movie.data.model

data class MoviesDto(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)