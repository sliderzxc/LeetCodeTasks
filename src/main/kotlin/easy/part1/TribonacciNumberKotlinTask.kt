package easy.part1

/**
The Tribonacci sequence Tn is defined as follows: T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

    Example 1:
    Input: n = 4
    Output: 4
    Explanation:
    T_3 = 0 + 1 + 1 = 2
    T_4 = 1 + 1 + 2 = 4

    Example 2:
    Input: n = 25
    Output: 1389537
 */
class TribonacciNumberKotlinTask {
    fun tribonacci(n: Int): Int {
        val array = Array(n+1) {0}
        if (n == 0) return 0
        if (n in 1..2) return 1
        array[0] = 0
        array[1] = 1
        array[2] = 1
        for (i in 3..n) {
            array[i] = array[i-1] + array[i-2] + array[i-3]
        }
        return array[n]
    }
}