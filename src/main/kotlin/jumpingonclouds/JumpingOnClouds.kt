package jumpingonclouds

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class JumpingOnClouds {

    @Test
    fun test() {
        val jumps = jumpingOnClouds(arrayOf(0, 1, 0, 1, 0, 0, 0, 0))

        Assertions.assertEquals(4, jumps)
    }

}

fun jumpingOnClouds(clouds: Array<Int>): Int {
    var jumps = 0
    var i = 0

    while (i < clouds.size - 1) {
        jumps++
        if (i + 2 < clouds.size && clouds[i + 2] == 0) {
            i += 2
            continue
        }
        i++
    }

    return jumps
}