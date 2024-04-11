package com.purshottam.store.movie.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.purshottam.store.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    val binding: FragmentMovieBinding
        get() = _binding!!

    private val movieViewModel: MovieViewModel by viewModels()
    private val movieAdapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        movieViewModel.searchMovie("69d66957eebff9666ea46bd464773cf0")
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            movieViewModel.movieStateFlow.collect {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.INVISIBLE
                }
                it.data.let { movie ->
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.rvMovies.adapter = movieAdapter
                    binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
                    movie?.toList()?.let { movieList -> movieAdapter.setMovieList(movieList) }
                }
            }
        }
    }
}