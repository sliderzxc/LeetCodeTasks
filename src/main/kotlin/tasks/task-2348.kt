package tasks

/**
 * Problem - https://leetcode.com/problems/number-of-zero-filled-subarrays
 */
class Task2348 {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var ans: Long = 0
        var count: Long = 0

        for (i in nums.indices) {
            if (nums[i] == 0) {
                count++
            } else {
                count = 0
            }
            ans += count
        }

        return ans
    }
}
