package com.pedrosiccha.retomoventi.domain.usecase

import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository

class GetPokemonEncounterLocationsUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(id: Int) = repository.getPokemonEncounterLocations(id)
}