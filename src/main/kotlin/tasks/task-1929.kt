package tasks

/**
 * Problem - https://leetcode.com/problems/concatenation-of-array
 */
class Task1929 {
    fun getConcatenation(nums: IntArray): IntArray = IntArray(nums.size * 2) { nums[it % nums.size] }
}