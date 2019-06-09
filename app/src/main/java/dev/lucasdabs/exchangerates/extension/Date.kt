package dev.lucasdabs.exchangerates.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(format: String = "dd/MM/yyyy") = SimpleDateFormat(format, Locale.getDefault()).format(this)