package dev.lucasdabs.exchangerates.di

import dev.lucasdabs.exchangerates.api.RestClient
import dev.lucasdabs.exchangerates.api.service.RatesService
import dev.lucasdabs.exchangerates.repository.ExchangeRepository
import org.junit.Assert
import org.junit.Test
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class InjectorTest {

    private val kodein = Kodein {
        import(Injector.apiModule())
        Injector.bindservice(RatesService::class, "testService")
        bind<ExchangeRepository>() with provider { ExchangeRepository(instance()) }
    }

    @Test
    fun `test if restClient instance should not be null`() {
        val instance by kodein.instance<RestClient>()
        Assert.assertNotNull(instance)
    }
}