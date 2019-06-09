package dev.lucasdabs.exchangerates.api.service

import dev.lucasdabs.exchangerates.api.data.Currency
import dev.lucasdabs.exchangerates.api.data.Exchange
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesService {

    @GET("latest")
    fun fetchData(@Query("base") currency: Currency): Observable<Exchange>
}