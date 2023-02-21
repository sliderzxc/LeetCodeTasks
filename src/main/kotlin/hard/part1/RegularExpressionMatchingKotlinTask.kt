package hard.part1

/**
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

    Example 1:
    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".

    Example 2:
    Input: s = "aa", p = "a*"
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes"aa".

    Example 3:
    Input: s = "ab", p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".
 */
class RegularExpressionMatchingKotlinTask {
    fun isMatch(s: String, p: String): Boolean {
        val n = s.length
        val m = p.length
        val dp = Array(n + 1) { BooleanArray(m + 1) }
        dp[0][0] = true
        for (j in 1..m) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2]
            }
        }
        for (i in 1..n) {
            for (j in 1..m) {
                if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1]
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || (p[j - 2] == s[i - 1] || p[j - 2] == '.') && dp[i - 1][j]
                }
            }
        }
        return dp[n][m]
    }
}