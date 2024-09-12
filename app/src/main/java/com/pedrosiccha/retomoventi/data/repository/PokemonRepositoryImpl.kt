package com.pedrosiccha.retomoventi.data.repository

import com.pedrosiccha.retomoventi.data.local.dao.PokemonDao
import com.pedrosiccha.retomoventi.data.mappers.toDomain
import com.pedrosiccha.retomoventi.data.mappers.toDomainPokemonStats
import com.pedrosiccha.retomoventi.data.mappers.toEntity
import com.pedrosiccha.retomoventi.data.remote.PokemonApiService
import com.pedrosiccha.retomoventi.data.remote.response.EvolutionChainLink
import com.pedrosiccha.retomoventi.domain.model.PokemonStats
import com.pedrosiccha.retomoventi.domain.model.Pokemon
import com.pedrosiccha.retomoventi.domain.model.PokemonEvolution
import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
): PokemonRepository {

    override suspend fun getAllPokemon(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val localPokemon = pokemonDao.getAllPokemon()

            if (localPokemon.isEmpty()) {
                val remotePokemonResponse = apiService.getAllPokemon(limit = 151)
                val remotePokemonEntities = remotePokemonResponse.results.map { it.toEntity() }
                pokemonDao.insertPokemon(remotePokemonEntities)
                remotePokemonResponse.results.map { it.toDomain() }
            } else {
                localPokemon.map { it.toDomain() }
            }
        }
    }

    override suspend fun searchPokemonByName(name: String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val localSearchResults = pokemonDao.searchPokemonByName("%$name%")
            localSearchResults.map { it.toDomain() }
        }
    }

    override suspend fun getPokemonDetails(id: Int): Pokemon {
        return withContext(Dispatchers.IO) {
            val pokemonDetails = apiService.getPokemonDetails(id)
            pokemonDetails.toDomain()
        }
    }

    override suspend fun getPokemonEvolutionChain(id: Int): List<PokemonEvolution> {
        return withContext(Dispatchers.IO) {
            val speciesResponse = apiService.getPokemonSpecies(id)
            val evolutionChainUrl = speciesResponse.evolution_chain.url
            val chainId = evolutionChainUrl.split("/").last { it.isNotEmpty() }.toInt()
            val evolutionChainResponse = apiService.getEvolutionChain(chainId)
            val evolutions = mutableListOf<PokemonEvolution>()
            parseEvolutionChain(evolutionChainResponse.chain, evolutions)
            evolutions
        }
    }

    private fun parseEvolutionChain(chainLink: EvolutionChainLink, evolutions: MutableList<PokemonEvolution>) {
        evolutions.add(PokemonEvolution(chainLink.species.name))
        for (evolution in chainLink.evolves_to) {
            parseEvolutionChain(evolution, evolutions)
        }
    }

    override suspend fun getPokemonEncounterLocations(id: Int): List<String> {
        return withContext(Dispatchers.IO) {
            val encounterLocations = apiService.getPokemonEncounters(id)
            encounterLocations.map { it.location_area.name }
        }
    }

    override suspend fun getPokemonStats(id: Int): List<PokemonStats> {
        val pokemonDetails = apiService.getPokemonDetails(id)
        return pokemonDetails.toDomainPokemonStats()
    }
}