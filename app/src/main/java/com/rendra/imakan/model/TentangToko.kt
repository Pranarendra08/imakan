package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TentangToko(
    var aktif:String ? = "",
    var namaToko:String ? = "",
    var transaksi:String ? = "",
    var urlToko:String ? = ""
) : Parcelable