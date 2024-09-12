package com.pedrosiccha.retomoventi.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val abilities: List<String>,
    val attacks: List<String>,
    val locations: List<String>
)
