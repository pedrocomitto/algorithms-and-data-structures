package addonetoarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class AddOneToArray {

    @Test
    fun test() {
        assertAll("should add one to an array", {
            assertArrayEquals(arrayOf(1, 5, 7, 8), addOneToArray(arrayOf(1, 5, 7, 7)))
            assertArrayEquals(arrayOf(1, 5, 8, 0), addOneToArray(arrayOf(1, 5, 7, 9)))
            assertArrayEquals(arrayOf(1, 6, 0, 0), addOneToArray(arrayOf(1, 5, 9, 9)))
            assertArrayEquals(arrayOf(2, 0, 0, 0), addOneToArray(arrayOf(1, 9, 9, 9)))
            assertArrayEquals(arrayOf(1, 0, 0, 0, 0), addOneToArray(arrayOf(9, 9, 9, 9)))
        })
    }
    
}

fun addOneToArray(ar: Array<Int>): Array<Int> {
    for (i in ar.size - 1 downTo 0) {
        if (ar[i] != 9) {
            ar[i]++
            break
        }

        if (i == 0 && ar[i] == 9) {
            val newArray = Array(ar.size + 1) { 0 }
            newArray[0] = 1

            return newArray
        }

        ar[i] = 0
    }

    return ar
}