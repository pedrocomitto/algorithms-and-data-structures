package algorithms.coutingvalleys

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CountingValleys {

    @Test
    fun test() {
        val valleys = countingValleys("DDUUUUDDDDDDUUUU")

        Assertions.assertEquals(2, valleys)
    }

}

fun countingValleys(path: String): Int {
    var position = 0
    var valleys = 0
    var lastPosition = 0

    for(i in path.toCharArray()) {
        lastPosition = position

        when (i) {
            'U' -> position++
            'D' -> position--
        }

        if (lastPosition == -1 && position == 0) {
            valleys++
        }
    }

    return valleys
}