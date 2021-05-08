package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.adapterui

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.Showtaiment

interface DataCallback {
    fun onItemClicked(dataPojo: Showtaiment)
}