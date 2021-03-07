package repeatedstring

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RepeatedString {

    @Test
    fun test() {
        val count = repeatedString2("a", 1000000000000)

        Assertions.assertEquals(1000000000000, count)
    }

}

fun repeatedString(s: String, n: Long): Long {
    // this approach works but has a bad performance, it was my first try
    var i = 1L
    var count = 0L

    while (i <= n) {
        for (c in s.toCharArray()) {
            if (c == 'a') {
                count++
            }

            if (i == n) {
                i++
                break
            }

            i++
        }
    }

    return count
}

fun repeatedString2(s: String, n: Long): Long {
    // this one is much better
    val div = n / s.length
    val mod = n % s.length

    val chars = s.toCharArray()

    var charsCount = 0L

    for (c in chars) {
        if (c == 'a') {
            charsCount++
        }
    }

    charsCount *= div

    var remainingCount = 0

    for (i in 0 until mod) {
        if (chars[i.toInt()] == 'a') {
           remainingCount++
        }
    }

    return charsCount + remainingCount
}
