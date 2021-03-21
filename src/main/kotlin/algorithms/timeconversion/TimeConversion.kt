package algorithms.timeconversion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TimeConversion {

    @Test
    fun test() {
        val time = timeConversion("12:02:32AM")

        Assertions.assertEquals("00:02:32", time)
    }

}

fun timeConversion(s: String): String {
    var hh = s.substring(0, 2)
    val mmss = s.substring(3, 8)
    val ampm = s.substring(8, 10)

    if (ampm == "PM" && hh != "12") {
        hh = (hh.toInt() + 12).toString()

    }

    if (ampm == "AM" && hh == "12") {
        hh = "00"
    }

    return "$hh:$mmss"
}
