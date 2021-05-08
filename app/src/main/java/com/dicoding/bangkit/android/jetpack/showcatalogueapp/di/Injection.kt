package com.dicoding.bangkit.android.jetpack.showcatalogueapp.di

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.ShowtaimentRemoteDataSource
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.ShowtaimentRepository

object Injection {

    fun provideShowtaimentRepository(): ShowtaimentRepository {
        val remoteDataSource = ShowtaimentRemoteDataSource.getInstance()
        return ShowtaimentRepository.getInstance(remoteDataSource)
    }
}