package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository

class SearchPokemonUseCase (private val repository: PokemonRepository) {
    suspend operator fun invoke(name: String) = repository.searchPokemonByName(name)
}