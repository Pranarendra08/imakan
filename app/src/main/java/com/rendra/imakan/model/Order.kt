package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Order(
    var ikan:String ? = "",
    var harga:String ? = "",
) : Parcelable
