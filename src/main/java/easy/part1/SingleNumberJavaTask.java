package easy.part1;

import java.util.LinkedHashMap;

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
public class SingleNumberJavaTask {
    int singleNumber(int[] nums) {
        LinkedHashMap<Integer, Integer> numbers = new LinkedHashMap<>();
        for (int num : nums) {
            Integer operation = numbers.get(num);
            if (num == 0 && operation != null) {
                numbers.replace(num, ++operation);
            } else if (num == 0) {
                numbers.put(num, ++num);
            } else if (operation != null) {
                numbers.replace(num, operation + num);
            } else {
                numbers.put(num, num);
            }
        }
        for (int num : numbers.keySet()) {
            if (num == numbers.get(num)) return num;
        }
        return 0;
    }
}