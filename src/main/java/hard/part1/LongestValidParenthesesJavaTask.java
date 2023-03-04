package hard.part1;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring
 * <p>
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * <p>
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * <p>
 * Example 3:
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParenthesesJavaTask {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLength = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i-2 >= 0 ? dp[i-2] : 0) + 2;
                } else if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i-1] + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}