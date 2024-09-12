package com.pedrosiccha.retomoventi.data.remote.response

data class PokemonDetailsResponse (
    val id: Int,
    val name: String,
    val types: List<TypeResponse>,
    val abilities: List<AbilityResponse>,
    val moves: List<MoveResponse>,
    val stats: List<StatResponse>,
    val location_area_encounters: String
)
