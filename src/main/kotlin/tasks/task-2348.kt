package tasks

/**
 * Problem - https://leetcode.com/problems/number-of-zero-filled-subarrays/
 *
 * This class provides a method to calculate the number of subarrays filled with 0 in an integer array.
 *
 * Given an integer array nums, the task is to return the number of subarrays filled with 0.
 * A subarray is defined as a contiguous non-empty sequence of elements within an array.
 *
 */

class Task2348 {
    /**
     * Calculates the number of subarrays filled with 0 in the given integer array.
     *
     * @param nums The input integer array.
     * @return The number of subarrays filled with 0.
     */
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
