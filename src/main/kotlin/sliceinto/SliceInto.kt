package sliceinto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SliceInto {

    @Test
    fun test() {
        val order = Order(mutableListOf(Item(300, "A"), Item(300, "B"), Item(600, "C")))

        val orders = sliceInto(500, order)

        // first order -> 300 A
        Assertions.assertEquals("A", orders[0].items[0].type)
        Assertions.assertEquals(300, orders[0].items[0].amount)
        // first order -> 200 B
        Assertions.assertEquals("B", orders[0].items[1].type)
        Assertions.assertEquals(200, orders[0].items[1].amount)

        // second order -> 100 B
        Assertions.assertEquals("B", orders[1].items[0].type)
        Assertions.assertEquals(100, orders[1].items[0].amount)
        // second order -> 400 C
        Assertions.assertEquals("C", orders[1].items[1].type)
        Assertions.assertEquals(400, orders[1].items[1].amount)

        // third order -> 200 C
        Assertions.assertEquals("C", orders[2].items[0].type)
        Assertions.assertEquals(200, orders[2].items[0].amount)
    }

}

fun sliceInto(sliceSize: Int, order: Order): List<Order> {
    var remaining = sliceSize
    val result = mutableListOf<Order>()
    var takingOrder = Order(mutableListOf())
    var totalAmount = order.items.sumBy { it.amount }

    for (item in order.items) {
        while (item.amount != 0) {
            if (item.amount <= remaining) {
                takingOrder.items.add(Item(item.amount, item.type))
                remaining -= item.amount
                totalAmount -= item.amount
                item.amount = 0
            }

            if (item.amount > remaining) {
                takingOrder.items.add(Item(remaining, item.type))
                item.amount -= remaining
                totalAmount -= remaining
                remaining = 0
            }

            if (remaining == 0 || totalAmount == 0) {
                result.add(takingOrder)
                takingOrder = Order(mutableListOf())
                remaining = sliceSize
            }
        }
    }

    return result
}

class Order(var items: MutableList<Item>)

class Item(
    var amount: Int = 0,
    var type: String
)