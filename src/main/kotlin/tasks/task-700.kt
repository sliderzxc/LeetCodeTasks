package tasks

/**
 * Problem - https://leetcode.com/problems/search-in-a-binary-search-tree
 */
class Task700 {
    fun searchBST(root: TreeNode?, value: Int): TreeNode? {
        var next = root

        while (next != null) {
            next = if (next.`val` == value) break
            else if (next.`val` > value) next.left else next.right
        }

        return next
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}