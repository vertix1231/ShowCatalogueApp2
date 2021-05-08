package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Movie
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Tvshow
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.utils.EspressoIdlingResource
import com.ilham.jpro.secondsubmission.data.source.remote.api.ApiClient
import retrofit2.await

class ShowtaimentRemoteDataSource {
    companion object {
        @Volatile
        private var instance: ShowtaimentRemoteDataSource? = null

        fun getInstance(): ShowtaimentRemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: ShowtaimentRemoteDataSource()
            }
    }

    suspend fun getNowPlayingMovies(
        callback: LoadNowPlayingMoviesCallback
    ) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getNowPlayingMovies().await().result?.let { listMovie ->
            callback.onAllMoviesReceived(
                listMovie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getDetailMovie(movieId).await().let { movie ->
            callback.onMovieDetailReceived(
                movie
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowOnTheAir(callback: LoadOnTheAirTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getTvShowOnTheAir().await().result?.let { listTvShow ->
            callback.onAllTvShowsReceived(
                listTvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback) {
        EspressoIdlingResource.increment()
        ApiClient.instance.getDetailTvShow(tvShowId).await().let { tvShow ->
            callback.onTvShowDetailReceived(
                tvShow
            )
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadNowPlayingMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<Movie>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(movieResponse: Movie)
    }

    interface LoadOnTheAirTvShowCallback {
        fun onAllTvShowsReceived(tvShowResponse: List<Tvshow>)
    }

    interface LoadTvShowDetailCallback {
        fun onTvShowDetailReceived(tvShowResponse: Tvshow)
    }
}