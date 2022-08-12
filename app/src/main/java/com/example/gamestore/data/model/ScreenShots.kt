package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScreenShots(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "image") var image: String? = null
) : Parcelable