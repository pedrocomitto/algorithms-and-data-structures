package algorithms.birthdaycakecandles

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BirthdayCakeCandles {

    @Test
    fun test() {
        val candles = birthdayCakeCandles(arrayOf(1, 2, 3, 5, 5, 6))

        Assertions.assertEquals(2, candles)
    }

}

fun birthdayCakeCandles(candles: Array<Int>): Int {
    var count = 0
    var control = 0

    for (i in candles) {
        if (i > control) {
            control = i
        }
    }

    for (i in candles) {
        if (i == control) {
            count++
        }
    }

    return count
}