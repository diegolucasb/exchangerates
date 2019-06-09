package dev.lucasdabs.exchangerates.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import dev.lucasdabs.exchangerates.R
import dev.lucasdabs.exchangerates.api.data.Currency
import dev.lucasdabs.exchangerates.extension.format
import dev.lucasdabs.exchangerates.repository.ExchangeRepository
import dev.lucasdabs.exchangerates.utils.State
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.support.kodein
import org.kodein.di.generic.instance
import java.util.*

class MainActivity : AppCompatActivity(), LifecycleOwner, KodeinAware {

    override val kodein: Kodein by kodein()
    private val repository by instance<ExchangeRepository>()

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders
            .of(this, MyFactory(repository))
            .get(MainViewModel::class.java)

        initViews()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchExchangeRate(Currency.USD)
    }

    private fun initViews() {

        viewModel.rate.observe(this, Observer {
            textViewCurrencyFrom.text = it.base

            val usdRate = it.rates[it.base]
            textViewRateFrom.text = usdRate ?: getString(R.string.zero_value)

            val plnRate = it.rates[Currency.PLN.toString()]
            textViewCurrencyTo.text = Currency.PLN.toString()
            textViewRateTo.text = plnRate ?: getString(R.string.zero_value)

            textViewUpdateAt.text = String.format(
                getString(R.string.updated_at),
                it.date.format(), Date().format("HH:mm:ss"))
        })

        viewModel.state.observe(this, Observer {
            when (it) {
                State.LOADING -> loading()
                State.DONE -> done()
                State.ERROR -> error()
            }
        })
    }

    private fun loading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun done() {
        progressBar.visibility = View.GONE
    }

    private fun error() {
        done()
        Toast.makeText(this, R.string.error_fetch_data, Toast.LENGTH_SHORT).show()
    }

    class MyFactory(private val repository: ExchangeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}
