package com.pedrosiccha.retomoventi.domain.repository

import com.pedrosiccha.retomoventi.domain.model.Pokemon
import com.pedrosiccha.retomoventi.domain.model.PokemonEvolution
import com.pedrosiccha.retomoventi.domain.model.PokemonStats

interface PokemonRepository {
    suspend fun getAllPokemon(): List<Pokemon>
    suspend fun searchPokemonByName(name: String): List<Pokemon>
    suspend fun getPokemonDetails(id: Int): Pokemon
    suspend fun getPokemonEvolutionChain(id: Int): List<PokemonEvolution>
    suspend fun getPokemonEncounterLocations(id: Int): List<String>
    suspend fun getPokemonStats(id: Int): List<PokemonStats>
}