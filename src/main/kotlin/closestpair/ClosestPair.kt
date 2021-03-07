package closestpair

import org.junit.jupiter.api.Test
import kotlin.math.abs

class ClosestPair {

    @Test
    fun test() {
        closestPair(arrayOf(1, 7, 3, 2, 9, 12), arrayOf(3, 6, 7, 2, -2, 9), 17)

        improvedClosestPair(arrayOf(1, 7, 3, 2, 9, 12), arrayOf(3, 6, 7, 2, -2, 9), 17)
    }

}

fun closestPair(first: Array<Int>, sec: Array<Int>, n: Int): Pair<Int, Int> {
    lateinit var closestPair: Pair<Int, Int>
    var actualDiff = n

    for (i in first) {
        for (j in sec) {
            if (i + j == n) {
                closestPair = Pair(i, j)
                break
            }

            if (abs(n - i - j) < actualDiff) {
                closestPair = Pair(i, j)
                actualDiff = abs(n - i - j)
            }
        }
    }

    return closestPair
}

fun improvedClosestPair(first: Array<Int>, sec: Array<Int>, n: Int): Pair<Int, Int> {
    // this one is way better
    lateinit var closestPair: Pair<Int, Int>

    first.sort()
    sec.sort()

    var x = 0
    var y = first.size - 1
    var smallestDiff = n

    while (x < first.size && y >= 0) {
        val xVal = first[x]
        val yVal = sec[y]
        val actualDiff = xVal + yVal - n

        if (abs(actualDiff) < smallestDiff) {
            smallestDiff = abs(actualDiff)
            closestPair = Pair(xVal, yVal)
        }

        if (actualDiff == 0) {
            return Pair(xVal, yVal)
        }

        if (actualDiff < 0) {
            x++
        } else {
            y--
        }

    }

    return closestPair
}