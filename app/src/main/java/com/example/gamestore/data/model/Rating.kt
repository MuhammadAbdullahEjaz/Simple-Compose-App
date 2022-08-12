package com.example.gamestore.data.model
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ratings(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "title") var title: String? = null,
    @Json(name = "count") var count: Int? = null,
    @Json(name = "percent") var percent: Double? = null
) : Parcelable