package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.DataDummy
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.ShowtaimentRepository
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest : TestCase(){

    private lateinit var mainViewModel: MainViewModel
    private val dummyMovie = DataDummy.generateDataMovieDummy()
    private val dummyTvShow = DataDummy.generateDataTvShowDummy()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showtaimentRepository: ShowtaimentRepository

    @Mock
    private lateinit var observer: Observer<List<Showtaiment>>

    @Before
    fun setUpp() {
        mainViewModel = MainViewModel(showtaimentRepository)
    }

    @Suppress("DEPRECATION")
    @Test
    fun getListNowPlayingMovies() {
        val movie = MutableLiveData<List<Showtaiment>>()
        movie.value = dummyMovie

        Mockito.`when`(showtaimentRepository.getMovies()).thenReturn(movie)

        val dataListMovie = mainViewModel.getListMovies().value

        verify(showtaimentRepository).getMovies()
        Assert.assertNotNull(dataListMovie)
        Assert.assertEquals(10, dataListMovie?.size)

        mainViewModel.getListMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getListOnTheAirTvShows() {
        val tvShow = MutableLiveData<List<Showtaiment>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(showtaimentRepository.getTvShow()).thenReturn(tvShow)

        val dataListTvShow = mainViewModel.getListTvShows().value

        verify(showtaimentRepository).getTvShow()
        Assert.assertNotNull(dataListTvShow)
        Assert.assertEquals(10, dataListTvShow?.size)

        mainViewModel.getListTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}