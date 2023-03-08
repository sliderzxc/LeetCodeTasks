package easy.part2;

import java.util.ArrayList;
import java.util.List;

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
public class SummaryRangesJavaTask {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            ranges.add(formatRange(lower, upper));
            return ranges;
        }
        if (nums[0] > lower) {
            ranges.add(formatRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                ranges.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[n - 1] < upper) {
            ranges.add(formatRange(nums[n - 1] + 1, upper));
        }
        return ranges;
    }

    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }
}