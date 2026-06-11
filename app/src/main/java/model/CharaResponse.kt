package com.example.praktam_2407051013.model

import com.google.gson.annotations.SerializedName

// Model untuk menangkap struktur JSON dari Jikan API MyAnimeList
data class CharaResponse(
    @SerializedName("data")
    val data: List<CharaApiData>
)

data class CharaApiData(
    @SerializedName("mal_id")
    val id: Int,
    @SerializedName("name")
    val nama: String,
    @SerializedName("about")
    val deskripsi: String?,
    @SerializedName("images")
    val images: CharaImages
)

data class CharaImages(
    @SerializedName("jpg")
    val jpg: JpgImage
)

data class JpgImage(
    @SerializedName("image_url")
    val imageUrl: String
)