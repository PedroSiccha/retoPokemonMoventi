package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository

class GetPokemonStatsUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(id: Int) = repository.getPokemonStats(id)
}
