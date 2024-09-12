package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.model.Pokemon
import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository

class GetPokemonDetailsUseCase(private val repository: PokemonRepository) {

    suspend operator fun invoke(id: Int): Pokemon {
        return repository.getPokemonDetails(id)
    }
}