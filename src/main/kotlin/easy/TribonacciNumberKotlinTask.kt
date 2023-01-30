package easy

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