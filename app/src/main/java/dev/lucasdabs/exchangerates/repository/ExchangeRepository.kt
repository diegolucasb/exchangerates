package dev.lucasdabs.exchangerates.repository

import dev.lucasdabs.exchangerates.api.data.Currency
import dev.lucasdabs.exchangerates.api.service.RatesService
import io.reactivex.schedulers.Schedulers

class ExchangeRepository(private val ratesService: RatesService) {

    fun fetchData(currency: Currency) =
        ratesService
            .fetchData(currency)
            .subscribeOn(Schedulers.newThread())
}