package tasks

/**
 * Problem - https://leetcode.com/problems/neither-minimum-nor-maximum/submissions/
 *
 * This class provides a method to find the non-minimum-or-maximum element in an integer array.
 */
class Task2733 {
    fun findNonMinOrMax(nums: IntArray): Int {
        nums.sort()
        return if (nums.size > 2) {
            nums.elementAt(nums.size / 2)
        } else {
            -1
        }
    }
}