package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.ShowtaimentRepository

class MainViewModel(private val showtaimentRepository: ShowtaimentRepository) : ViewModel() {

    fun getListMovies(): LiveData<List<Showtaiment>> = showtaimentRepository.getMovies()

    fun getListTvShows(): LiveData<List<Showtaiment>> = showtaimentRepository.getTvShow()

//    fun getListMovie(): List<Showtaiment> = DataDummy.generateDataMovieDummy()
//
//    fun getListTvShow(): List<Showtaiment> = DataDummy.generateDataTvShowDummy()


}