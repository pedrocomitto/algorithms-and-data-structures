package datastructures.list

import java.lang.IndexOutOfBoundsException

class KList<E> {
    var size = 0
    private var elements = arrayOfNulls<Any>(DEFAULT_CAPACITY)

    companion object {
        const val DEFAULT_CAPACITY = 10
    }

    fun add(e: E) {
        if (size == elements.size) {
            ensureCapacity()
        }

        elements[size++] = e
    }

    fun remove(index: Int) {
        rangeCheck(index)

        val numMoved = size - index - 1

        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved)

            elements[--size] = null
        }
    }

    @Suppress("UNCHECKED_CAST")
    operator fun get(index: Int): E {
        rangeCheck(index)

        return elements[index] as E
    }

    private fun rangeCheck(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
    }

    private fun ensureCapacity() {
        elements = elements.copyOf(elements.size * 2)
    }
}