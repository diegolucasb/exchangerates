package dev.lucasdabs.exchangerates.core

import android.app.Application
import android.content.Context
import dev.lucasdabs.exchangerates.api.RestClient
import dev.lucasdabs.exchangerates.api.service.RatesService
import dev.lucasdabs.exchangerates.di.Injector
import dev.lucasdabs.exchangerates.repository.ExchangeRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(Injector.apiModule())
        import(Injector.bindservice(RatesService::class, "exchangeService"))

        //repository
        bind<ExchangeRepository>() with provider { ExchangeRepository(instance()) }
        bind<Context>() with provider { applicationContext }
    }
}