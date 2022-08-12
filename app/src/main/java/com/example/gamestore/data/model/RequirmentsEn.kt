package com.example.gamestore.data.model

import com.squareup.moshi.Json

data class RequirementsEn(
    @Json(name = "minimum") var minimum: String? = null,
    @Json(name = "recommended") var recommended: String? = null
)