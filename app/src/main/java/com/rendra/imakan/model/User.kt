package com.rendra.imakan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
    var username:String ?="",
    var phoneNumber:String ?="",
    var email:String ?="",
    var url:String ?="",
    var password:String ?=""
) : Parcelable