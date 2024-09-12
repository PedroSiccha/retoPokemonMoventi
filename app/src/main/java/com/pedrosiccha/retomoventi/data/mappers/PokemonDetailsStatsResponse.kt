package com.pedrosiccha.retomoventi.data.mappers

import com.pedrosiccha.retomoventi.data.remote.response.PokemonDetailsResponse
import com.pedrosiccha.retomoventi.domain.model.PokemonStats

fun PokemonDetailsResponse.toPokemonStats(): List<PokemonStats> {
    return this.stats.map {
        PokemonStats(
            name = it.stat.name,
            baseStat = it.base_stat
        )
    }
}