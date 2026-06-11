package com.example.praktam_2407051013.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktam_2407051013.data.CharaRepository
import com.example.praktam_2407051013.model.CharaApiData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Menangani State UI
sealed interface CharaUiState {
    object Loading : CharaUiState
    data class Success(val listChara: List<CharaApiData>) : CharaUiState
    data class Error(val message: String) : CharaUiState
}

class CharaViewModel : ViewModel() {
    private val repository = CharaRepository()

    private val _uiState = MutableStateFlow<CharaUiState>(CharaUiState.Loading)
    val uiState: StateFlow<CharaUiState> = _uiState

    init {
        getCharaFromApi()
    }

    fun getCharaFromApi() {
        viewModelScope.launch {
            _uiState.value = CharaUiState.Loading
            try {
                val response = repository.fetchCharaData()
                _uiState.value = CharaUiState.Success(response.data)
            } catch (e: Exception) {
                _uiState.value = CharaUiState.Error("Gagal memuat data, periksa koneksi internet")
            }
        }
    }
}