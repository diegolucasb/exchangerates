package dev.lucasdabs.exchangerates.ui.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import dev.lucasdabs.exchangerates.R
import dev.lucasdabs.exchangerates.extension.format
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import java.util.*

class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun shouldOpenActivityWithCurrencyValues() {
        onView(withId(R.id.textViewCurrencyFrom))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textViewRateFrom))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textViewCurrencyTo))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textViewRateTo))
            .check(matches(isDisplayed()))

        Thread.sleep(5000)

        val currentDate = Date().format()
        onView(withId(R.id.textViewUpdateAt))
            .check(matches(withText(CoreMatchers.containsString(currentDate))))

        onView(withId(R.id.textViewTitle))
            .check(matches(withText(R.string.currency_rate_title)))
    }
}