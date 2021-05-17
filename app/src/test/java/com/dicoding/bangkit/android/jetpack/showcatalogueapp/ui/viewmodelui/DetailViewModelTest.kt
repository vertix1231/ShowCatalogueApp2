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

@Suppress("DEPRECATION")
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest : TestCase(){

    private lateinit var detailViewModel: DetailViewModel
    private val dummyCourseMovie = DataDummy.generateDataMovieDummy()[0]
    private val movieId = dummyCourseMovie.id
    private val dummyCourseTvshow = DataDummy.generateDataTvShowDummy()[0]
    private val tvshowId = dummyCourseTvshow.id

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showtaimentRepository: ShowtaimentRepository

    @Mock
    private lateinit var observer: Observer<Showtaiment>

    @Before
    fun setUpp() {
        detailViewModel = DetailViewModel(showtaimentRepository)
    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<Showtaiment>()
        movieDummy.value = dummyCourseMovie

        Mockito.`when`(showtaimentRepository.getMovieDetail(movieId)).thenReturn(movieDummy)

        val movieData = detailViewModel.getMovieDetail(movieId).value as Showtaiment

        Assert.assertNotNull(movieData)
        assertEquals(dummyCourseMovie.id, movieData.id)

        detailViewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(dummyCourseMovie)

    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<Showtaiment>()
        tvShowDummy.value = dummyCourseTvshow

        Mockito.`when`(showtaimentRepository.getTvShowDetail(tvshowId)).thenReturn(tvShowDummy)

        val tvShowData = detailViewModel.getTvShowDetail(tvshowId).value as Showtaiment

        Assert.assertNotNull(tvShowData)
        assertEquals(dummyCourseTvshow.id, tvShowData.id)

        detailViewModel.getTvShowDetail(tvshowId).observeForever(observer)
        verify(observer).onChanged(dummyCourseTvshow)
    }
}