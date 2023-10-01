package com.unissula.activityfragmentexample.modul

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Person(
    val id : String = UUID.randomUUID().toString(),
    val name : String,
    val job: String,
    val profileDesc : String,
    val profilePictUrl : String
) : Parcelable