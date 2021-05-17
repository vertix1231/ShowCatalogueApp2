@file:Suppress("DEPRECATION")

package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.DataDummy
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ShowtaimentRepositoryTest : TestCase() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(ShowtaimentRemoteDataSource::class.java)
    private val catalogRepository = FakeShowtaimentRepository(remote)

    private val listMovieResponse = DataDummy.generateDataMovieDummyResponse()
    private val movieId = listMovieResponse[0].id
    private val listTvShowResponse = DataDummy.generateDataTvShowDummyResponse()
    private val tvShowId = listTvShowResponse[0].id
    private val movieResponse = DataDummy.generateDataMovieDummyResponse()[0]
    private val tvShowResponse = DataDummy.generateDataTvShowDummyResponse()[0]


    @Test
    fun testGetMovies() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[0] as ShowtaimentRemoteDataSource.LoadNowPlayingMoviesCallback).onAllMoviesReceived(listMovieResponse)
                null
            }.`when`(remote).getNowPlayingMovies(any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovies())

        runBlocking {
            verify(remote).getNowPlayingMovies(any())
        }

        Assert.assertNotNull(data)
        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())

    }

    @Test
    fun testGetMovieDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as ShowtaimentRemoteDataSource.LoadMovieDetailCallback).onMovieDetailReceived(movieResponse)
                null
            }.`when`(remote).getMovieDetail(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getMovieDetail(movieId))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId), any())
        }

        Assert.assertNotNull(data)
        assertEquals(movieResponse.id, data.id)
    }

    @Test
    fun testGetTvShow() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as ShowtaimentRemoteDataSource.LoadOnTheAirTvShowCallback).onAllTvShowsReceived(listTvShowResponse)
                null
            }.`when`(remote).getTvShowOnTheAir(any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShow())

        runBlocking {
            verify(remote).getTvShowOnTheAir(any())
        }

        Assert.assertNotNull(data)
        assertEquals(listTvShowResponse.size.toLong(), data.size.toLong())

    }

    @Test
    fun testGetTvShowDetail() {
        runBlocking {
            doAnswer {invocation ->
                (invocation.arguments[1] as ShowtaimentRemoteDataSource.LoadTvShowDetailCallback).onTvShowDetailReceived(tvShowResponse)
                null
            }.`when`(remote).getTvShowDetail(eq(tvShowId), any())
        }

        val data = LiveDataTestUtil.getValue(catalogRepository.getTvShowDetail(tvShowId))

        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId), any())
        }

        Assert.assertNotNull(data)
        assertEquals(tvShowResponse.id, data.id)
    }
}