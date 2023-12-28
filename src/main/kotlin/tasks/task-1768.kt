package tasks

/**
 * Problem - https://leetcode.com/problems/merge-strings-alternately
 *
 * This class provides a method to merge 2 words into 1 word, merge the strings by adding
 * letters in alternating order
 */
class Task1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        var i1 = 0
        var i2 = 0

        while (i1 < word1.length && i2 < word2.length) {
            sb.append(word1[i1++]).append(word2[i2++])
        }

        if (i1 < word1.length) sb.append(word1.substring(i1))
        if (i2 < word2.length) sb.append(word2.substring(i2))

        return sb.toString()
    }
}