package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddedByStatus(

    @Json(name = "yet") var yet: Int? = null,
    @Json(name = "owned") var owned: Int? = null,
    @Json(name = "beaten") var beaten: Int? = null,
    @Json(name = "toplay") var toplay: Int? = null,
    @Json(name = "dropped") var dropped: Int? = null,
    @Json(name = "playing") var playing: Int? = null

) : Parcelable