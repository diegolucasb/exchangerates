package dev.lucasdabs.exchangerates.ui.main

import dev.lucasdabs.exchangerates.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityUnitTest {

    private lateinit var activity: MainActivity

    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        activity.setTheme(R.style.AppTheme)
    }

    @Test
    fun `test if activity wasn't null`() {
        Assert.assertNotNull(activity)
    }
}