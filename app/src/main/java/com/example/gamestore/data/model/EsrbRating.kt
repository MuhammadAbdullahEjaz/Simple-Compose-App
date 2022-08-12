package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json

@kotlinx.parcelize.Parcelize
data class EsrbRating(

    @Json(name = "id") var id: Int? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "slug") var slug: String? = null

) : Parcelable