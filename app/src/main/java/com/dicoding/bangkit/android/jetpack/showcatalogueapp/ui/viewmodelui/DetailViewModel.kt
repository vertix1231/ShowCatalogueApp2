package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.ShowtaimentRepository

class DetailViewModel(private val showtaimentRepository: ShowtaimentRepository) : ViewModel() {
    fun getMovieDetail(movieId: Int): LiveData<Showtaiment> =
        showtaimentRepository.getMovieDetail(movieId)

    fun getTvShowDetail(tvShowId: Int): LiveData<Showtaiment> = showtaimentRepository.getTvShowDetail(
        tvShowId
    )
//    private lateinit var movieId: String
//    private lateinit var tvShowId: String
//
//    fun getListMovie(): ArrayList<Showtaiment> =
//        DataDummy.generateDataMovieDummy() as ArrayList<Showtaiment>
//
//    fun getListTvShow(): ArrayList<Showtaiment> =
//        DataDummy.generateDataTvShowDummy() as ArrayList<Showtaiment>
//
//    fun setMovieId(movieId: String) {
//        this.movieId = movieId
//    }
//
//    fun setTvShowId(tvShowId: String) {
//        this.tvShowId = tvShowId
//    }
//
//    fun getDetailMovieById(): Showtaiment {
//        lateinit var result: Showtaiment
//        val listMovie = getListMovie()
//        for (movie in listMovie) {
//            if (movie.id == movieId) {
//                result = movie
//                break
//            }
//        }
//        return result
//    }
//
//    fun getDetailTvShowById(): Showtaiment {
//        lateinit var result: Showtaiment
//        val listTvShow = getListTvShow()
//        for (tvShow in listTvShow) {
//            if (tvShow.id == tvShowId) {
//                result = tvShow
//                break
//            }
//        }
//        return result
//    }
}