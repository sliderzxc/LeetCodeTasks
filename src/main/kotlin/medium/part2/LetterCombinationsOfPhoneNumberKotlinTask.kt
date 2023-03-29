package medium.part2

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order. A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 */
class LetterCombinationsOfPhoneNumberKotlinTask {
    private val digitToLetters: HashMap<Char?, String?> = object : HashMap<Char?, String?>() {
        init {
            put('2', "abc")
            put('3', "def")
            put('4', "ghi")
            put('5', "jkl")
            put('6', "mno")
            put('7', "pqrs")
            put('8', "tuv")
            put('9', "wxyz")
        }
    }

    fun letterCombinations(digits: String?): List<String>? {
        val result: MutableList<String> = ArrayList()
        if (digits == null || digits.length == 0) {
            return result
        }
        backtrack(result, StringBuilder(), digits)
        return result
    }

    private fun backtrack(result: MutableList<String>, combination: StringBuilder, digits: String) {
        if (digits.length == 0) {
            result.add(combination.toString())
        } else {
            val letters = digitToLetters[digits[0]]
            for (i in 0 until letters!!.length) {
                combination.append(letters[i])
                backtrack(result, combination, digits.substring(1))
                combination.deleteCharAt(combination.length - 1)
            }
        }
    }
}