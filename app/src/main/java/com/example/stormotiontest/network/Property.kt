package com.example.stormotiontest.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Property(
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "info") val info: String,
    @Json(name = "img_url") val imgUrl: String,
    @Json(name = "url") val url: String
    ): Parcelable