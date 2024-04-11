package com.purshottam.store.movie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purshottam.store.movie.domain.use_case.MovieUseCase
import com.purshottam.store.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    private val _movieMutableStateFlow = MutableStateFlow<MovieState>(MovieState())
    val movieStateFlow: StateFlow<MovieState> = _movieMutableStateFlow

    fun searchMovie(apiKey: String) {
        movieUseCase(apiKey).onEach {
            when (it) {
                is Resource.Loading -> {
                    _movieMutableStateFlow.value = MovieState(isLoading = true)
                }

                is Resource.Error -> {
                    _movieMutableStateFlow.value = MovieState(error = it.message ?: "Error")
                }

                is Resource.Success -> {
                    _movieMutableStateFlow.value = MovieState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}