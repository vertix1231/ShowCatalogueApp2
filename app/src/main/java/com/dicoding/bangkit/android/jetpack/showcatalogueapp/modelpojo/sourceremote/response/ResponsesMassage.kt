package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response

import com.google.gson.annotations.SerializedName

data class ResponsesMassage<T>(
    @SerializedName("status_message")
    val statusMessage: String? = null,
    @SerializedName("status_code")
    val statusCode: Int? = null,
    @SerializedName("results")
    val result: List<T>? = null
)
