package tasks

/**
 * Problem - https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * This class provides a method to find the largest string x that divides both given strings str1 and str2.
 * A string x divides str1 and str2 if and only if str1 = x + ... + x and str2 = x + ... + x (i.e., x
 * is concatenated with itself one or more times).
 */
class Task1071 {
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) {
            return ""
        }

        var l1 = str1.length
        var l2 = str2.length
        while (l1 != l2) {
            if (l1 > l2) l1 -= l2
            else l2 -= l1
        }

        return str1.substring(0, l1)
    }
}