package com.example.core.utils

import java.text.NumberFormat
import java.util.Calendar
import java.util.Currency
import java.util.Date
import java.util.regex.Pattern

fun numbersToCurrency(number: Int): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.currency = Currency.getInstance("USD")
    return numberFormat.format(number)
}

fun numbersToFormat(number: Int): String {
    val numberFormat = NumberFormat.getNumberInstance()
    return numberFormat.format(number)
}

fun getCurrentDate(): Date = Calendar.getInstance().time