package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.remote.response.PokemonDetailsResponse
import com.pedrosiccha.retomoventi.domain.model.Pokemon

fun PokemonDetailsResponse.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name },
        attacks = moves.map { it.move.name },
        locations = listOf()
    )
}