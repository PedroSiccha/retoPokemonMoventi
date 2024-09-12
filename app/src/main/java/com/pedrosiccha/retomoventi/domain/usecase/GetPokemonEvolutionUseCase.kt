package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonEvolutionUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke(id: Int) = repository.getPokemonEvolutionChain(id)
}