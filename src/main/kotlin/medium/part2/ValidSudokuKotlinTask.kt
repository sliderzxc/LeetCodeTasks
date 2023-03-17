package medium.part2

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * Example 1:
 * <p>
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * <p>
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
class ValidSudokuKotlinTask {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (row in 0..8) {
            val digits: MutableSet<Char> = HashSet()
            for (col in 0..8) {
                val digit = board[row][col]
                if (digit != '.' && digits.contains(digit)) {
                    return false
                }
                digits.add(digit)
            }
        }
        for (col in 0..8) {
            val digits: MutableSet<Char> = HashSet()
            for (row in 0..8) {
                val digit = board[row][col]
                if (digit != '.' && digits.contains(digit)) {
                    return false
                }
                digits.add(digit)
            }
        }
        for (i in 0..2) {
            for (j in 0..2) {
                val digits: MutableSet<Char> = HashSet()
                for (row in i * 3 until (i + 1) * 3) {
                    for (col in j * 3 until (j + 1) * 3) {
                        val digit = board[row][col]
                        if (digit != '.' && digits.contains(digit)) {
                            return false
                        }
                        digits.add(digit)
                    }
                }
            }
        }
        return true
    }
}