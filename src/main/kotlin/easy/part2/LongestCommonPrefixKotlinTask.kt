package easy.part2

/**
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */
class LongestCommonPrefixKotlinTask {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val prefix = StringBuilder()
        val first = strs[0]
        for (i in first.indices) {
            val char = first[i]
            for (j in 1 until strs.size) {
                if (i >= strs[j].length || strs[j][i] != char) {
                    return prefix.toString()
                }
            }
            prefix.append(char)
        }
        return prefix.toString()
    }
}