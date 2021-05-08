package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Movie
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response.Tvshow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ShowtaimentRepository private constructor(private val showtaimentRemoteDataSource: ShowtaimentRemoteDataSource):ShowtaimentDataSource{

    companion object {
        @Volatile
        private var instance: ShowtaimentRepository? = null

        fun getInstance(showtaimentDataSource: ShowtaimentRemoteDataSource): ShowtaimentRepository =
            instance ?: synchronized(this) {
                instance ?: ShowtaimentRepository(showtaimentDataSource)
            }
    }

    override fun getMovies(): LiveData<List<Showtaiment>> {
        val listMovie = MutableLiveData<List<Showtaiment>>()
        CoroutineScope(IO).launch {
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
                    listMovie.postValue(movielistdata)
                }

            })
        }
        return listMovie
    }

    override fun getMovieDetail(movieId: Int): LiveData<Showtaiment> {
        val movieDetailSelected = MutableLiveData<Showtaiment>()
        CoroutineScope(IO).launch {
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
        val listTvshow = MutableLiveData<List<Showtaiment>>()
        CoroutineScope(IO).launch {
            showtaimentRemoteDataSource.getTvShowOnTheAir(object : ShowtaimentRemoteDataSource.LoadOnTheAirTvShowCallback{
                override fun onAllTvShowsReceived(tvShowResponse: List<Tvshow>) {
                    val tvListData = ArrayList<Showtaiment>()
                    for (i in tvListData){
                        val tvShow = Showtaiment(
                            i.id,
                            i.name,
                            i.desc,
                            i.poster,
                            i.img_preview
                        )
                        tvListData.add(tvShow)
                    }
                    listTvshow.postValue(tvListData)
                }
            })
        }
        return listTvshow
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<Showtaiment> {
        val tvShowDetailSelected = MutableLiveData<Showtaiment>()
        CoroutineScope(IO).launch {
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