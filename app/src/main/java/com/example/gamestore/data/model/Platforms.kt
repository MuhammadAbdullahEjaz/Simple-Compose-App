package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Platforms(

    @Json(name = "platform") var platform: Platform? = Platform(),
    @Json(name = "released_at") var releasedAt: String? = null,
//    @Json(name = "requirements_en") var requirementsEn: RequirementsEn? = RequirementsEn(),
//    @Json(name = "requirements_ru") var requirementsRu: String? = null

) : Parcelable