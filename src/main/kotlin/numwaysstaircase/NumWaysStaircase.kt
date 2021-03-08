package numwaysstaircase

import org.junit.jupiter.api.Test

class NumWaysStaircase {

    @Test
    fun test() {
        println(numWays(15))
        println(numWaysBottomUp(15))
    }

}

fun numWays(n: Int): Int {
    if (n == 0 || n == 1) {
        return 1
    }

    return numWays(n - 1) + numWays(n - 2)
}

fun numWaysBottomUp(n: Int): Int? {
    if (n == 0 || n == 1) return 1

    val nums = arrayOfNulls<Int>(n + 1)
    nums[0] = 1
    nums[1] = 1

    for (i in 2 until nums.size) {
        nums[i] = nums[i - 2]!! + nums[i - 1]!!
    }

    return nums[n]
}
