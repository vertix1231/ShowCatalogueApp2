package com.dicoding.bangkit.android.jetpack.showcatalogueapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.di.Injection
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.ShowtaimentRepository
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui.DetailViewModel
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.viewmodelui.MainViewModel

class ViewModelFactory private constructor(private val showtaimentRepository: ShowtaimentRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideShowtaimentRepository())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(showtaimentRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(showtaimentRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}