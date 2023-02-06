package easy.part1;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an integer number n, return the difference between the product of its digits and the sum of its digits.

    Example 1:
    Input: n = 234
    Output: 15
    Explanation:
    Product of digits = 2 * 3 * 4 = 24
    Sum of digits = 2 + 3 + 4 = 9
    Result = 24 - 9 = 15

    Example 2:
    Input: n = 4421
    Output: 21
    Explanation:
    Product of digits = 4 * 4 * 2 * 1 = 32
    Sum of digits = 4 + 4 + 2 + 1 = 11
    Result = 32 - 11 = 21
 */
public class SubtractTheProductAndSumOfDigitsOfAnIntegerJavaTask {
    public int subtractProductAndSum(int n) {
        int multiResult = 1;
        int plusResult = 0;
        List<Integer> integers = String.valueOf(n).chars().boxed().toList();
        for (Integer integer : integers) {
            multiResult *= Character.getNumericValue(integer);
            plusResult += Character.getNumericValue(integer);
        }
        return multiResult - plusResult;
    }
}