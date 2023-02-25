package medium.part1

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * <p>
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
class ZigzagConversionKotlinTask {
    fun convert(s: String, numRows: Int): String? {
        if (numRows == 1) {
            return s
        }
        val rows: MutableList<StringBuilder> = ArrayList()
        for (i in 0 until numRows.coerceAtMost(s.length)) {
            rows.add(StringBuilder())
        }
        var currentRow = 0
        var goingDown = false
        for (c in s.toCharArray()) {
            rows[currentRow].append(c)
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown
            }
            currentRow += if (goingDown) 1 else -1
        }
        val result = StringBuilder()
        for (row in rows) {
            result.append(row)
        }
        return result.toString()
    }
}