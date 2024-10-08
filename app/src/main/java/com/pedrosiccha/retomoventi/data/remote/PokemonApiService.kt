package com.pedrosiccha.retomoventi.data.remote

import com.pedrosiccha.retomoventi.data.remote.response.EncounterLocationResponse
import com.pedrosiccha.retomoventi.data.remote.response.EvolutionChainResponse
import com.pedrosiccha.retomoventi.data.remote.response.PokemonDetailsResponse
import com.pedrosiccha.retomoventi.data.remote.response.PokemonResponse
import com.pedrosiccha.retomoventi.data.remote.response.PokemonSpeciesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getAllPokemon(@Query("limit") limit: Int): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): PokemonDetailsResponse

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(@Path("id") id: Int): PokemonSpeciesResponse

    @GET("pokemon/{id}/encounters")
    suspend fun getPokemonEncounters(@Path("id") id: Int): List<EncounterLocationResponse>

    @GET("evolution-chain/{id}/")
    suspend fun getEvolutionChain(@Path("id") id: Int): EvolutionChainResponse
}