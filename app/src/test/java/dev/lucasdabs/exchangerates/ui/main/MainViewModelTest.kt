package dev.lucasdabs.exchangerates.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.lucasdabs.exchangerates.api.data.Currency
import dev.lucasdabs.exchangerates.api.service.RatesService
import dev.lucasdabs.exchangerates.repository.ExchangeRepository
import dev.lucasdabs.exchangerates.utils.State
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private lateinit var service: RatesService
    private lateinit var repository: ExchangeRepository

    @Before
    fun setup() {
        service = mockk(relaxed = true)
        repository = ExchangeRepository(service)
        viewModel = MainViewModel(repository)
    }

    @Test
    fun `test if live data was properly posted`() {
        var state: State? = null
        viewModel.state.observeForever {
            state = it
        }

        viewModel.fetchExchangeRate(Currency.USD)
        Assert.assertEquals(State.LOADING, state)
    }
}