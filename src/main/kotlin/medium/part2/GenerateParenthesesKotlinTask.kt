package medium.part2

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 */
class GenerateParenthesesKotlinTask {
    fun generateParenthesis(n: Int): List<String>? {
        val result: MutableList<String> = ArrayList()
        backtrack(result, StringBuilder(), 0, 0, n)
        return result
    }

    private fun backtrack(result: MutableList<String>, current: StringBuilder, open: Int, close: Int, n: Int) {
        if (current.length == n * 2) {
            result.add(current.toString())
            return
        }
        if (open < n) {
            current.append('(')
            backtrack(result, current, open + 1, close, n)
            current.setLength(current.length - 1)
        }
        if (close < open) {
            current.append(')')
            backtrack(result, current, open, close + 1, n)
            current.setLength(current.length - 1)
        }
    }
}