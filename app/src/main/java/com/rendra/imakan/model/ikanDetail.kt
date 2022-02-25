package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ikanDetail(
    var jarak:String ? = "",
    var nama:String ? = "",
    var url:String ? = "",
    var harga:String ? = "",
    var tersedia:String ? = "",
    var rate:String ? = "",
    var namaToko:String ? = "",
) : Parcelable
