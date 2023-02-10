package medium.part1

/**
Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class LongestSubstringWithoutRepeatingCharactersKotlinTask {
    fun lengthOfLongestSubstring(s: String): Int {
        val set: MutableSet<Char> = HashSet()
        var maxLength = 0
        var left = 0
        for (right in s.indices) {
            if (!set.contains(s[right])) {
                set.add(s[right])
                maxLength = maxLength.coerceAtLeast(right - left + 1)
            } else {
                while (s[left] != s[right]) {
                    set.remove(s[left])
                    left++
                }
                set.remove(s[left])
                left++
                set.add(s[right])
            }
        }
        return maxLength
    }
}