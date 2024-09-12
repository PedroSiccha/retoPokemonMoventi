package com.pedrosiccha.retomoventi.data.remote.response

data class PokemonDetailsResponse (
    val id: Int,
    val name: String,
    val types: List<TypeResponse>,
    val abilities: List<AbilityResponse>,
    val moves: List<MoveResponse>,
    val location_area_encounters: String // Este es el endpoint para obtener los lugares donde se puede encontrar al Pokémon
)
