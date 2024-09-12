package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository

class GetPokemonEvolutionUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(id: Int) = repository.getPokemonEvolutionChain(id)
}