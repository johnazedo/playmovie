package com.example.domain.usecases

import com.example.data.repositories.MovieRepository
import com.example.model.Movie

class GetMovieUseCaseImpl(
    private val movieRepository: MovieRepository
): GetMovieUseCase{
    override suspend fun getMovies(genresId: Int): List<Movie> {
        return movieRepository.getMoviesByGenres(genresId)
    }

    override suspend fun getMoviesMock(): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                title = "Testing 1",
                description = "Testing 1",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 2,
                title = "Testing 2",
                description = "Testing 2",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 3,
                title = "Testing 3",
                description = "Testing 3",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 4,
                title = "Testing 4",
                description = "Testing 4",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            ),
            Movie(
                id = 5,
                title = "Testing 5",
                description = "Testing 5",
                imageUrl = "https://image.tmdb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg"
            )
        )
    }
}

interface GetMovieUseCase {
    suspend fun getMovies(genresId: Int): List<Movie>
    suspend fun getMoviesMock(): List<Movie>
}