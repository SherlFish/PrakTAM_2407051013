package com.example.praktam_2407051013.data

import com.example.praktam_2407051013.model.CharaResponse
import com.example.praktam_2407051013.network.CharaApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharaRepository {
    private val apiService: CharaApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/") // Base URL Jikan API Public
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(CharaApiService::class.java)
    }

    suspend fun fetchCharaData(): CharaResponse {
        return apiService.getCharacters()
    }
}