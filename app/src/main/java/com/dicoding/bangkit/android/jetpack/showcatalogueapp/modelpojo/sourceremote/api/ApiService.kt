package com.ilham.jpro.secondsubmission.data.source.remote.api

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.BuildConfig
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Movie
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.ResponsesMassage
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Tvshow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("movie/now_playing")
    fun getNowPlayingMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_THEMOVIE
    ) : Call<ResponsesMassage<Movie>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
            @Path("movie_id") movieId: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_THEMOVIE
    ) : Call<Movie>

    @GET("tv/on_the_air")
    fun getTvShowOnTheAir(
            @Query("api_key") apiKey: String = BuildConfig.API_THEMOVIE
    ) : Call<ResponsesMassage<Tvshow>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
            @Path("tv_id") tvShowId: Int,
            @Query("api_key") apiKey: String = BuildConfig.API_THEMOVIE
    ) : Call<Tvshow>

}