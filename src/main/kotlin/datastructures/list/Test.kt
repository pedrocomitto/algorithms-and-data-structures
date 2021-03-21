package datastructures.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.IndexOutOfBoundsException

class Test {

    @Test
    fun test() {
        val list = KList<Int>()

        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        list.add(6)
        list.add(7)
        list.add(8)
        list.add(9)
        list.add(10)
        list.add(11)
        list.add(12)

        assertEquals(Integer.valueOf(1), list[0])
        assertEquals(Integer.valueOf(10), list[9])
        assertEquals(Integer.valueOf(12), list[11])

        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            list[20]
        }
    }

    @Test
    fun shouldRemove() {
        val list = KList<Int>()

        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.remove(2)

        assertEquals(3, list.size)
        assertEquals(1, list[0])
        assertEquals(2, list[1])
        assertEquals(4, list[2])

    }

}