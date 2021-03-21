package datastructures.stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.util.EmptyStackException

class KStackTest {

    @Test
    fun test() {
        val stack = KStack<Int>()

        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())

        assertThrows(EmptyStackException::class.java) {
            stack.pop()
        }
    }

}