package com.pedrosiccha.retomoventi.data.repository

import com.pedrosiccha.retomoventi.data.local.dao.PokemonDao
import com.pedrosiccha.retomoventi.data.mappers.toDomain
import com.pedrosiccha.retomoventi.data.mappers.toEntity
import com.pedrosiccha.retomoventi.data.remote.PokemonApiService
import com.pedrosiccha.retomoventi.domain.model.Pokemon
import com.pedrosiccha.retomoventi.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val apiService: PokemonApiService,
    private val pokemonDao: PokemonDao
): PokemonRepository {
    override suspend fun getAllPokemon(): List<Pokemon> {
        // Obtener la lista de Pokémon de la base de datos local
        return withContext(Dispatchers.IO) {
            val localPokemon = pokemonDao.getAllPokemon()

            // Si la base de datos local está vacía, obtenemos desde la API
            if (localPokemon.isEmpty()) {
                // Llamada a la API para obtener los primeros 151 Pokémon
                val remotePokemon = apiService.getAllPokemon()

                // Guardar los Pokémon obtenidos desde la API en la base de datos local
                pokemonDao.insertPokemon(remotePokemon.map { it.toEntity() })

                // Retornar la lista obtenida desde la API
                remotePokemon
            } else {
                // Convertir las entidades locales a modelo de dominio
                localPokemon.map { it.toDomain() }
            }
        }
    }

    override suspend fun searchPokemonByName(name: String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            // Realizar la búsqueda en la base de datos local
            val localSearchResults = pokemonDao.searchPokemonByName("%$name%")

            // Convertir las entidades obtenidas en la búsqueda a modelos de dominio
            localSearchResults.map { it.toDomain() }
        }
    }

    override suspend fun getPokemonDetails(id: Int): Pokemon {
        // Obtener detalles de un Pokémon específico desde la API (suponemos que este dato no está en la base local)
        return withContext(Dispatchers.IO) {
            val pokemonDetails = apiService.getPokemonDetails(id)
            pokemonDetails.toDomain()  // Convertir a modelo de dominio
        }
    }
}