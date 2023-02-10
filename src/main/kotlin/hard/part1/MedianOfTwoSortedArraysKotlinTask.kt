package hard.part1

/**
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

    Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
class MedianOfTwoSortedArraysKotlinTask {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = nums1.plus(nums2)
        mergedArray.sort()
        val median = if (mergedArray.size % 2 != 0) {
            mergedArray[mergedArray.size / 2].toDouble()
        } else
            (mergedArray[mergedArray.size / 2].toDouble() + mergedArray[mergedArray.size / 2 - 1].toDouble()) / 2
        return median
    }
}