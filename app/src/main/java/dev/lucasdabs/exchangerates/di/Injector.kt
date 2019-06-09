package dev.lucasdabs.exchangerates.di

import dev.lucasdabs.exchangerates.api.RestClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import kotlin.reflect.KClass

object Injector {

    fun apiModule() = Kodein.Module("api") {
        bind<RestClient>() with singleton { RestClient() }
    }

    inline fun <reified T : Any> bindservice(service: KClass<T>, name: String) =
        Kodein.Module(name) {
            bind<T>() with provider {
                instance<RestClient>().buildCall(service)
            }
        }
}