package com.pedrosiccha.retomoventi.data.local.util

fun extractIdFromUrl(url: String): Int {
    return url.split("/").last { it.isNotEmpty() }.toInt()
}