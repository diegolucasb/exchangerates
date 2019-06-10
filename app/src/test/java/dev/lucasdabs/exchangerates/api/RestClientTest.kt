package dev.lucasdabs.exchangerates.api

import dev.lucasdabs.exchangerates.api.service.RatesService
import org.junit.Assert
import org.junit.Test

class RestClientTest {

    @Test
    fun `test if restClient service instance is not null`() {
        val api = RestClient()
        val service = api.buildCall(RatesService::class)

        Assert.assertNotNull(service)
    }
}