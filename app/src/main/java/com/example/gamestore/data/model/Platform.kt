package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Platform(

    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "slug") var slug: String? = null,
    @Json(name = "image") var image: String? = null,
    @Json(name = "year_end") var yearEnd: String? = null,
    @Json(name = "year_start") var yearStart: String? = null,
    @Json(name = "games_count") var gamesCount: Int? = null,
    @Json(name = "image_background") var imageBackground: String? = null

) : Parcelable