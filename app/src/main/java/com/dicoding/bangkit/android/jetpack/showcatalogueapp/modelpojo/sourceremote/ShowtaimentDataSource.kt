package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote

import androidx.lifecycle.LiveData
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment

interface ShowtaimentDataSource {
    fun getMovies(): LiveData<List<Showtaiment>>

    fun getMovieDetail(movieId: Int): LiveData<Showtaiment>

    fun getTvShow(): LiveData<List<Showtaiment>>

    fun getTvShowDetail(tvShowId: Int): LiveData<Showtaiment>

}