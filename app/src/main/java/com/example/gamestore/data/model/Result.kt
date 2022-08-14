package com.example.gamestore.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Results(

    @Json(name = "id") var id: Int? = null,
    @Json(name = "slug") var slug: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "released") var released: String? = null,
    @Json(name = "tba") var tba: Boolean? = null,
    @Json(name = "background_image") var backgroundImage: String? = null,
    @Json(name = "rating") var rating: Double? = null,
    @Json(name = "rating_top") var ratingTop: Int? = null,
    @Json(name = "ratings") var ratings: List<Ratings> = listOf(),
    @Json(name = "ratings_count") var ratingsCount: Int? = null,
    @Json(name = "reviews_text_count") var reviewsTextCount: Int? = null,
    @Json(name = "added") var added: Int? = null,
    @Json(name = "added_by_status") var addedByStatus: AddedByStatus? = AddedByStatus(),
    @Json(name = "metacritic") var metacritic: Int? = null,
    @Json(name = "playtime") var playtime: Int? = null,
    @Json(name = "suggestions_count") var suggestionsCount: Int? = null,
    @Json(name = "updated") var updated: String? = null,
    @Json(name = "user_game") var userGame: String? = null,
    @Json(name = "reviews_count") var reviewsCount: Int? = null,
    @Json(name = "saturated_color") var saturatedColor: String? = null,
    @Json(name = "dominant_color") var dominantColor: String? = null,
    @Json(name = "platforms") var platforms: List<Platforms>? = listOf(),
    @Json(name = "genres") var genres: List<Genres> = listOf(),
    @Json(name = "clip") var clip: String? = null,
    @Json(name = "tags") var tags: List<Tags>? = listOf(),
    @Json(name = "esrb_rating") var esrbRating: EsrbRating? = EsrbRating(),
    @Json(name = "short_screenshots") var shortScreenshots: List<ScreenShots> = listOf()

) : Parcelable