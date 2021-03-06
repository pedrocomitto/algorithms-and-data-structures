package minmaxsum

import org.junit.jupiter.api.Test

class MinMaxSum {

    @Test
    fun test() {
        miniMaxSum(arrayOf(140638725, 436257910, 953274816, 734065819, 362748590))
    }

}

fun miniMaxSum(arr: Array<Int>) {
    var minSum = 0L
    var maxSum = 0L

    arr.sort()

    for (i in arr.indices) {
        if (i == 0) {
            minSum += arr[i]
            continue
        }

        if (i == arr.size - 1) {
            maxSum += arr[i]
            continue
        }

        minSum += arr[i]
        maxSum += arr[i]
    }

    println("$minSum $maxSum")
}