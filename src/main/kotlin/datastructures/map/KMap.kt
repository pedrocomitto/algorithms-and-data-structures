package datastructures.map

class KEntry<K, V>(
    val key: K,
    var value: V
)

class KMap<K, V> {
    var size: Int = 0
    private var entries = arrayOfNulls<KEntry<K, V>>(DEFAULT_CAPACITY)

    companion object {
        const val DEFAULT_CAPACITY = 16
    }

    fun get(key: K): V? {
        for (entry in entries) {
            if (entry != null) {
                if (entry.key == key) {
                    return entry.value
                }
            }
        }

        return null
    }

    fun put(key: K, value: V) {
        var insert = true

        for (entry in entries) {
            if (entry?.key == key) {
                entry?.value = value
                insert = false
            }
        }

        if (insert) {
            ensureCapacity()
            entries[size++] = KEntry(key, value)
        }
    }

    fun remove(key: K) {
        for (i in entries.indices) {
            if (entries[i]?.key == key) {
                entries[i] = null
                size--
                condenseArray(i)
            }
        }
    }

    private fun ensureCapacity() {
        if (size == entries.size) {
            entries = entries.copyOf(entries.size * 2)
        }
    }

    private fun condenseArray(start: Int) {
        for (i in start..size) {
            entries[i] = entries[i + 1]
        }
    }

}