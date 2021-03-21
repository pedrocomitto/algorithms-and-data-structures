package datastructures.queue


import java.lang.IllegalStateException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class KQueueTest {

    @Test
    fun test() {
        val queue = KQueue<Int>(5)

        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        assertEquals(1, queue.dequeue())
        assertEquals(2, queue.dequeue())

        queue.enqueue(4)

        assertEquals(3, queue.dequeue())
        assertEquals(4, queue.dequeue())
    }

    @Test
    fun `should return an exception when its full`() {
        val queue = KQueue<Int>(3)

        queue.enqueue(1)
        queue.enqueue(1)
        queue.enqueue(1)

        assertThrows(IllegalStateException::class.java) {
            queue.enqueue(1)
        }
    }

}