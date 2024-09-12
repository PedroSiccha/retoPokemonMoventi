package com.pedrosiccha.retomoventi.data.remote

import com.pedrosiccha.retomoventi.data.remote.response.PokemonDetailsResponse
import com.pedrosiccha.retomoventi.domain.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon?limit=151")
    suspend fun getAllPokemon(): List<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): PokemonDetailsResponse
}