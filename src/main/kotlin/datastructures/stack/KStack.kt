package datastructures.stack

import java.util.EmptyStackException


class KStack<E> {

    companion object {
        const val DEFAULT_INITIAL_CAPACITY = 16
    }

    var size = 0
    private var elements = arrayOfNulls<Any>(DEFAULT_INITIAL_CAPACITY)

    fun push(e: E) {
        ensureCapacity()
        elements[size++] = e
    }

    @Suppress("UNCHECKED_CAST")
    fun pop(): E {
        if(size == 0) {
            throw EmptyStackException()
        }

        val result = elements[--size]

        elements[size] = null

        return result as E
    }

    private fun ensureCapacity() {
        if (size == elements.size) {
            elements = elements.copyOf(elements.size * 2)
        }
    }

}