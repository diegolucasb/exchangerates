package dev.lucasdabs.exchangerates.api.data

import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat

class ExchangeTest {

    private lateinit var mockedJson: String
    private val gson by lazy { GsonBuilder().create() }

    @Before
    fun setup() {
        mockedJson = "{\n" +
                "\"base\": \"USD\",\n" +
                "\"rates\": {\n" +
                "\"USD\": 1,\n" +
                "\"BRL\": 3.8782045596,\n" +
                "\"PLN\": 3.7890534906\n" +
                "},\n" +
                "\"date\": \"2019-06-07\"\n" +
                "}"
    }

    @Test
    fun `test if exchange data class is properly parsed from json`() {
        val response = gson.fromJson(mockedJson, Exchange::class.java)
        val exchange = Exchange(
            "USD",
            mapOf("USD" to "1", "BRL" to "3.8782045596", "PLN" to "3.7890534906"),
            SimpleDateFormat("yyyy-MM-dd").parse("2019-06-07"))

        Assert.assertNotNull(response)
        Assert.assertEquals(3, response.rates.size)
        Assert.assertEquals(response, exchange)
    }
}