package dev.lucasdabs.exchangerates.extension

import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateTest {

    @Test
    fun `test if date is properly formatted`() {
        val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("01/01/2019")
        val formatted = date.format()
        Assert.assertEquals("01/01/2019", formatted)
    }

    @Test
    fun `test if date is properly formatted with custom mask`() {
        val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("01/01/2019")
        val formatted = date.format("dd-MM-yyyy")
        Assert.assertEquals("01-01-2019", formatted)
    }
}