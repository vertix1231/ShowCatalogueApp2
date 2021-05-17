package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Movie
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Tvshow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeShowtaimentRepository (private val showtaimentRemoteDataSource: ShowtaimentRemoteDataSource):ShowtaimentDataSource {

    override fun getMovies(): LiveData<List<Showtaiment>> {
        val listMovie = MutableLiveData<List<Showtaiment>>()
        CoroutineScope(Dispatchers.IO).launch {
            showtaimentRemoteDataSource.getNowPlayingMovies(object : ShowtaimentRemoteDataSource.LoadNowPlayingMoviesCallback{
                override fun onAllMoviesReceived(movieResponse: List<Movie>) {
                    val movielistdata = ArrayList<Showtaiment>()
                    for (i in movieResponse){
                        val movie = Showtaiment(
                            i.id,
                            i.name,
                            i.desc,
                            i.poster,
                            i.img_preview,
                        )
                        movielistdata.add(movie)
                    }
                    Log.d("cek movie","onAllTvshowReceived data semua tvshow diterima dengan : $movielistdata")

                    listMovie.postValue(movielistdata)
                }

            })
        }
        return listMovie
    }

    override fun getMovieDetail(movieId: Int): LiveData<Showtaiment> {
        val movieDetailSelected = MutableLiveData<Showtaiment>()
        CoroutineScope(Dispatchers.IO).launch {
            showtaimentRemoteDataSource.getMovieDetail(movieId,object : ShowtaimentRemoteDataSource.LoadMovieDetailCallback{
                override fun onMovieDetailReceived(movieResponse: Movie) {
                    val moviedetail = Showtaiment(
                        movieResponse.id,
                        movieResponse.name,
                        movieResponse.desc,
                        movieResponse.poster,
                        movieResponse.img_preview,
                    )

                    movieDetailSelected.postValue(moviedetail)
                }

            })
        }
        return movieDetailSelected
    }

    override fun getTvShow(): LiveData<List<Showtaiment>> {
        val listTvshowSelected = MutableLiveData<List<Showtaiment>>()
        CoroutineScope(Dispatchers.IO).launch {
            showtaimentRemoteDataSource.getTvShowOnTheAir(object : ShowtaimentRemoteDataSource.LoadOnTheAirTvShowCallback{
                override fun onAllTvShowsReceived(tvShowResponse: List<Tvshow>) {
                    val tvListData = ArrayList<Showtaiment>()
                    for (i in tvShowResponse){
                        val tvShow = Showtaiment(
                            i.id,
                            i.name,
                            i.desc,
                            i.poster,
                            i.img_preview
                        )
                        tvListData.add(tvShow)
                    }
                    Log.d("cek tvshow","onAllTvshowReceived data semua tvshow diterima dengan : $tvListData")

                    listTvshowSelected.postValue(tvListData)
                }
            })
        }
        return listTvshowSelected
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<Showtaiment> {
        val tvShowDetailSelected = MutableLiveData<Showtaiment>()
        CoroutineScope(Dispatchers.IO).launch {
            showtaimentRemoteDataSource.getTvShowDetail(tvShowId,object : ShowtaimentRemoteDataSource.LoadTvShowDetailCallback{
                override fun onTvShowDetailReceived(tvShowResponse: Tvshow) {
                    val tvShow = Showtaiment(
                        tvShowResponse.id,
                        tvShowResponse.name,
                        tvShowResponse.desc,
                        tvShowResponse.poster,
                        tvShowResponse.img_preview,
                    )

                    tvShowDetailSelected.postValue(tvShow)
                }
            })
        }
        return tvShowDetailSelected
    }
}