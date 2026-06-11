package com.example.praktam_2407051013.network

import com.example.praktam_2407051013.model.CharaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharaApiService {
    // Mengambil karakter berdasarkan query pencarian ("Devil May Cry")
    @GET("characters")
    suspend fun getCharacters(
        @Query("q") query: String = "Devil May Cry"
    ): CharaResponse
}