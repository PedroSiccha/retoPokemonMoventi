package com.pedrosiccha.retomoventi.data.remote.response

import com.pedrosiccha.retomoventi.data.remote.result.PokemonResult

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)