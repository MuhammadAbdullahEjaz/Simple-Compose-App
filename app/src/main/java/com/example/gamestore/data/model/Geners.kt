package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genres(

    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "slug") var slug: String? = null,
    @Json(name = "games_count") var gamesCount: Int? = null,
    @Json(name = "image_background") var imageBackground: String? = null

) : Parcelable