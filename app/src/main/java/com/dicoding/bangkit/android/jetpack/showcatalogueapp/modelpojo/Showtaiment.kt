package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Showtaiment(
    var id: Int = 0,
    var name: String? = null,
    var desc: String? = null,
    var poster: String? = null,
    var img_preview: String? = null
) : Parcelable

//@Parcelize
//data class Showtaiment(
//    var id: String,
//    var name: String,
//    var desc: String,
//    var poster: String,
//    var img_preview: String
//) : Parcelable
