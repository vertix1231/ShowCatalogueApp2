package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.sourceremote.response

import com.google.gson.annotations.SerializedName

data class Tvshow(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("overview")
    var desc: String? = null,
    @SerializedName("poster_path")
    var poster: String? = null,
    @SerializedName("backdrop_path")
    var img_preview: String? = null
)
