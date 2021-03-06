package salesbymatch

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SalesByMatch {

    @Test
    fun test() {
        val result = sockMerchant(arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20))

        Assertions.assertEquals(3, result)
    }

}

fun sockMerchant(socks: Array<Int>): Int {
    var pairs = 0
    val set = hashSetOf<Int>()

    for (sock in socks) {
        if (set.contains(sock)) {
            pairs += 1
            set.remove(sock)
        } else {
            set.add(sock)
        }
    }

    return pairs
}