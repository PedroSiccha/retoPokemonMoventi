package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.remote.result.PokemonResult
import com.pedrosiccha.retomoventi.domain.model.Pokemon

fun PokemonResult.toDomain(): Pokemon {
    return Pokemon(
        id = 0,
        name = this.name,
        types = listOf(),
        abilities = listOf(),
        attacks = listOf(),
        locations = listOf()
    )
}