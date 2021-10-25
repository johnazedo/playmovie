package com.example.data

import com.example.data.model.Movie
import com.example.data.response.MovieResponse
import com.example.data.response.toMovie

class MovieRepositoryImpl(
    private val service: MovieService
): MovieRepository{
    override suspend fun getMovie(movieId: Int): Movie {
        val result = service.getMovie(movieId).parseResponse()

        when (result) {
            is Output.Success -> {
                val movie: MovieResponse = result.value
                return movie.toMovie()
            }
            is Output.Failure -> throw Exception()
        }
    }

    override suspend fun getMoviesByGenres(genresId: Int): List<Movie> {
        val result = service.discoveryMoviesByGenres(genresId).parseResponse()

        when (result) {
            is Output.Success -> {
                // TODO: Movie has been null
                val movies: List<MovieResponse> = result.value.movies
                return movies.map {
                    it.toMovie()
                }
            }
            is Output.Failure -> throw Exception()
        }
    }
}


interface MovieRepository {
    suspend fun getMovie(movieId: Int) : Movie
    suspend fun getMoviesByGenres(genresId: Int): List<Movie>
}
