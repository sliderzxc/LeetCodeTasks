package hard.part1

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
class LongestValidParenthesesKotlinTask {
    fun longestValidParentheses(s: String): Int {
        val n = s.length
        val dp = IntArray(n)
        var maxLength = 0
        for (i in 1 until n) {
            if (s[i] == ')') {
                if (s[i - 1] == '(') {
                    dp[i] = (if (i - 2 >= 0) dp[i - 2] else 0) + 2
                } else if (i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + (if (i - dp[i - 1] - 2 >= 0) dp[i - dp[i - 1] - 2] else 0) + 2
                }
                maxLength = Math.max(maxLength, dp[i])
            }
        }
        return maxLength
    }
}