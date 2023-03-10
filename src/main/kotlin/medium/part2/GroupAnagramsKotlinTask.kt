package medium.part2

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
 * original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
class GroupAnagramsKotlinTask {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, MutableList<String>>()
        for (s in strs) {
            val sortedS = s.toCharArray().sorted().joinToString("")
            if (groups.containsKey(sortedS)) {
                groups[sortedS]?.add(s)
            } else {
                groups[sortedS] = mutableListOf(s)
            }
        }
        return groups.values.toList()
    }
}