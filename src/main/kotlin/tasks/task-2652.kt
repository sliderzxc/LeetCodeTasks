package tasks

/**
 * Problem - https://leetcode.com/problems/sum-multiples/
 *
 * This class provides a method to calculate the sum of multiples
 * of 3, 5, and 7 up to a given number 'n'.
 */
class Task2652 {
    fun sumOfMultiples(n: Int): Int {
        var result = 0
        for (i in 1..n) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                result += i
            }
        }
        return result
    }
}