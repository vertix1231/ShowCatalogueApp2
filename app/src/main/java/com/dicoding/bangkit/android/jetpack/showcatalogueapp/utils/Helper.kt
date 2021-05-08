package com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.BuildConfig

object Helper {

    const val TYPE_MOVIE = "TYPE_MOVIE"
    const val TYPE_TVSHOW = "TYPE_TVSHOW"
    const val API_IMAGE_ENDPOINT = BuildConfig.API_IMAGE_ENDPOINT
    const val ENDPOINT_POSTER_SIZE_W185 = "w185"
    const val ENDPOINT_POSTER_SIZE_W780 = "w780"


    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }
}