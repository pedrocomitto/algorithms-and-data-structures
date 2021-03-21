package datastructures.queue

import java.lang.IllegalStateException

class KQueue<E>(size: Int) {
    private var front = -1
    private var rear = -1
    private var elements = arrayOfNulls<Any>(size)

    fun enqueue(e: E) {
        if (isFull()) {
            throw IllegalStateException()
        }

        if (isEmpty()) {
            front = 0
        }

        elements[++rear] = e
    }

    @Suppress("UNCHECKED_CAST")
    fun dequeue(): E {
        if (isEmpty()) {
            throw IllegalStateException()
        }

        val result = elements[front] as E
        elements[front] = null
        if (front >= rear) {
            front = -1
            rear = -1
        } else {
            front++
        }

        return result
    }

    fun isFull() =
        front == 0 && rear == elements.size - 1

    fun isEmpty() =
        front == -1
}