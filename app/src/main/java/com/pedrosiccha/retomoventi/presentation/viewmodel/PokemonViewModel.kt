package com.pedrosiccha.retomoventi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosiccha.retomoventi.domain.usecase.GetAllPokemonUseCase
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getAllPokemonUseCase: GetAllPokemonUseCase
): ViewModel() {
    fun loadPokemon() {
        viewModelScope.launch {
            // Lógica para cargar Pokémon usando el caso de uso
        }
    }
}