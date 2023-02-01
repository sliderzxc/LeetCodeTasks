package easy

/**
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1
 */
class SingleNumberKotlinTask {
    fun singleNumber(nums: IntArray): Int {
        val numbersHashMap = mutableMapOf<Int, Int>()
        var result = 0
        nums.forEach { number ->
            if (number == 0) {
                numbersHashMap[number] = numbersHashMap[number]?.plus(1) ?: (1)
            } else {
                numbersHashMap[number] = numbersHashMap[number]?.plus(number) ?: number
            }
        }
        numbersHashMap.forEach { (key, value) ->
            if (key == value) result = value
        }
        return result
    }
}