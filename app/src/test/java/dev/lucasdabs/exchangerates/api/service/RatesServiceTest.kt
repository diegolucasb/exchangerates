package dev.lucasdabs.exchangerates.api.service

import dev.lucasdabs.exchangerates.api.data.Currency
import dev.lucasdabs.exchangerates.api.data.Exchange
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class RatesServiceTest {

    private lateinit var service: RatesService
    private lateinit var response: Observable<Exchange>

    @Before
    fun setup() {
        service = mockk()
        response = mockk(relaxed = true)
    }

    @Test
    fun `test if service method is properly called`() {
        val currency = mockk<Currency>()
        every { service.fetchData( currency ) } returns response
        service.fetchData(currency)
        verify { service.fetchData(currency) }
    }
}