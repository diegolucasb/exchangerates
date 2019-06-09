package dev.lucasdabs.exchangerates.api.data

import java.util.*

data class Exchange(
    val base: String,
    val rates: Map<String, String>,
    val date: Date)