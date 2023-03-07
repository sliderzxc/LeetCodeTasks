package medium.part2

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 */
class PermutationsKotlinTask {
    fun permute(nums: IntArray): List<List<Int>>? {
        val result: MutableList<List<Int>> = ArrayList()
        backtrack(nums, ArrayList(), result)
        return result
    }

    private fun backtrack(nums: IntArray, tempList: MutableList<Int>, result: MutableList<List<Int>>) {
        if (tempList.size == nums.size) {
            result.add(ArrayList(tempList))
        } else {
            for (i in nums.indices) {
                if (tempList.contains(nums[i])) {
                    continue
                }
                tempList.add(nums[i])
                backtrack(nums, tempList, result)
                tempList.removeAt(tempList.size - 1)
            }
        }
    }
}