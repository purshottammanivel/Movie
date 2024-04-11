package com.purshottam.store.movie.presentation

import com.purshottam.store.movie.domain.model.Movie

data class MovieState(
    val data: List<Movie>? = null,
    val error: String = "",
    val isLoading: Boolean = false
)