package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository

class GetAllPokemonUseCase (private val repository: PokemonRepository) {
    suspend operator fun invoke() = repository.getAllPokemon()
}