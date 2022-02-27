package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ulasan(
    var nama:String ? = "",
    var komentar:String ? = "",
    var url:String ? = "",
) : Parcelable
