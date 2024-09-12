package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.local.entities.PokemonEntity
import com.pedrosiccha.retomoventi.data.local.util.extractIdFromUrl
import com.pedrosiccha.retomoventi.data.remote.result.PokemonResult

fun PokemonResult.toEntity(): PokemonEntity {
    return PokemonEntity(
        id = extractIdFromUrl(url),
        name = name,
        types = "",
        abilities = "",
        attacks = "",
        locations = ""
    )
}