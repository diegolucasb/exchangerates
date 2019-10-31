# Exchange rates - Android App Sample
You can download the APK [here](https://github.com/diegolucasb/exchangerates/tree/master/apk).

## About the project
An Android app that displays current “USD” and “PLN” currency rates from this endpoint https://api.exchangeratesapi.io/latest. It is refreshed every 30 seconds.

The project was written 100% in `Kotlin`, implemented MVVM pattern with dependency injection using [`Kodein`](https://kodein.org/Kodein-DI/). For retrieving data from the network `Retrofit` with `RxJava` was used. 
Also a `repository` pattern to abstract the data load was implemented.

The project was developed using [gitflow](https://datasift.github.io/gitflow/IntroducingGitFlow.html)

## What the project uses:
* Android Gradle Plugin 3+
* Android API 24+
* Kotlin
* MVVM
* Retrofit
* RxJava
* Kodein
* GSon
* JUnit
* Mockk
* Robolectric
* Espresso
* Ktlint
* Detekt

## Test
* Unit tests 
* Instrumented test 

## Lint
Android SDK already has a [lint](https://developer.android.com/studio/write/lint.html) 
toolkit so if you want to edit the severity of problems jumps to ```lint.xml``` in this project. 
It also uses [ktlint](https://ktlint.github.io/) and [detekt](https://github.com/arturbosch/detekt) for code smells.
To run it: ```./gradlew check```

## TODO: Improvements
- definitely, do a better UI
- cache strategy
- increase code coverage
- used a better solution for [`idleResource`](https://developer.android.com/training/testing/espresso/idling-resource) on Espresso test, but it was used `Thread.sleep` to keep it simple.

## Author
Build with ❤️ and any feedback is welcome
Lucas Diego Amaral
