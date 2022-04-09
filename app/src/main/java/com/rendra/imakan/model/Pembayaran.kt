package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pembayaran(
    var nama:String ? = "",
    var url:String ? = ""
) : Parcelable
