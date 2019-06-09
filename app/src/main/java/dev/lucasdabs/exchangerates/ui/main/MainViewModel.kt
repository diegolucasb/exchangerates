package dev.lucasdabs.exchangerates.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lucasdabs.exchangerates.api.data.Currency
import dev.lucasdabs.exchangerates.api.data.Exchange
import dev.lucasdabs.exchangerates.repository.ExchangeRepository
import dev.lucasdabs.exchangerates.utils.State
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class MainViewModel(private val repository: ExchangeRepository) : ViewModel() {

    companion object {
        private const val REFRESH_TIME = 30L
    }
    private val compositeDisposable = CompositeDisposable()

    val rate = MutableLiveData<Exchange>()
    val state = MutableLiveData<State>()

    fun fetchExchangeRate(currency: Currency) {
        updateState(State.LOADING)
        compositeDisposable.add(
            repository.fetchData(currency)
                .repeatWhen { observable: Observable<Any> -> observable.delay(REFRESH_TIME, TimeUnit.SECONDS) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onFetchSuccess, ::onFetchError)
        )
    }

    private fun updateState(value: State) {
        state.postValue(value)
    }

    private fun onFetchError(error: Throwable) {
        updateState(State.ERROR)
    }

    private fun onFetchSuccess(exchange: Exchange) {
        updateState(State.DONE)
        rate.postValue(exchange)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}