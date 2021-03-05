package staircase

import org.junit.jupiter.api.Test

class StairCaseTest() {

    @Test
    fun test() {
        stairCase(50)
    }

}

fun stairCase(n: Int) {
    val space = " "
    val block = "#"
    var line = ""

    for (i in n downTo 1) {
        for (j in 1 until i) {
            line = line.plus(space)
        }

        for (k in i..n) {
            line = line.plus(block)
        }

        line = line.plus("\n")
    }

    println(line)
}

fun stairCase2(n: Int) {
    for (i in 1..n) {
        println("#".repeat(i).padStart(n))
    }
}