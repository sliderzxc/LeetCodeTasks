package easy.part2

/**
 * You are given a sorted unique integer array nums. A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums
 * is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * Example 1:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * Example 2:
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
class SummaryRangesKotlinTask {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String>? {
        val ranges: MutableList<String> = ArrayList()
        val n = nums.size
        if (n == 0) {
            ranges.add(formatRange(lower, upper))
            return ranges
        }
        if (nums[0] > lower) {
            ranges.add(formatRange(lower, nums[0] - 1))
        }
        for (i in 1 until n) {
            if (nums[i] > nums[i - 1] + 1) {
                ranges.add(formatRange(nums[i - 1] + 1, nums[i] - 1))
            }
        }
        if (nums[n - 1] < upper) {
            ranges.add(formatRange(nums[n - 1] + 1, upper))
        }
        return ranges
    }

    private fun formatRange(lower: Int, upper: Int): String {
        return if (lower == upper) {
            lower.toString()
        } else {
            "$lower->$upper"
        }
    }
}