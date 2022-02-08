package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ikanDetail(
    var jarak:String ? = "",
    var nama:String ? = "",
    var url:String ? = "",
    var harga:String ? = "",
    var toko:String ? = "",
    var tersedia:String ? = "",
    var rating:String ? = "",

) : Parcelable
