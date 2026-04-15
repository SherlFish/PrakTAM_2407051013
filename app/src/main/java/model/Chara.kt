package com.example.praktam_2407051013.model
import androidx.annotation.DrawableRes

data class Chara (
    val nama: String,
    val deskripsi: String,
    val harga : Int,
    @DrawableRes val imageRes: Int
)