package com.unissula.activityfragmentexample.modul

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val job: String,
    val profileDesc: String,
    val profilePicUrl: String
) : Parcelable