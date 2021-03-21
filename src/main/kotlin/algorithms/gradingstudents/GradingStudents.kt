package algorithms.gradingstudents

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GradingStudents {

    @Test
    fun test() {
        val grades = gradingStudents(arrayOf(73, 67, 38, 33))

        Assertions.assertArrayEquals(arrayOf(75, 67, 40, 33), grades)
    }

}

fun gradingStudents(grades: Array<Int>): Array<Int> {
    for (i in grades.indices) {
        if (grades[i] < 38 || (grades[i] % 5) < 3) {
            grades[i] = grades[i]
        } else {
            grades[i] = grades[i] + (5 - (grades[i] % 5))
        }

    }

    return grades
}