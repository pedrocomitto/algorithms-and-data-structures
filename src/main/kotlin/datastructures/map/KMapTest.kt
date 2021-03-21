package datastructures.map

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KMapTest {

    @Test
    fun test() {
        val map = KMap<String, String>()

        map.put("key0", "value0")
        map.put("key1", "value1")
        map.put("key2", "value2")
        map.put("key3", "value3")
        map.put("key4", "value4")
        map.put("key5", "value5")
        map.put("key6", "value6")
        map.put("key7", "value7")
        map.put("key8", "value8")
        map.put("key9", "value9")
        map.put("key10", "value10")
        map.put("key11", "value11")
        map.put("key12", "value12")
        map.put("key13", "value13")
        map.put("key14", "value14")
        map.put("key15", "value15")
        map.put("key16", "value16")
        map.put("key17", "value17")
        map.put("key18", "value18")
        
        assertEquals("value15", map.get("key15"))
        assertEquals(19, map.size)

        map.remove("key2")

        assertEquals(null, map.get("key2"))
        assertEquals(18, map.size)
    }

}