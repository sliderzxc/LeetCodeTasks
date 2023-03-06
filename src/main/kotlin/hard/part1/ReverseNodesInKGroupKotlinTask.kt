package hard.part1

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
 * multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
class ReverseNodesInKGroupKotlinTask {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var curr = head
        var count = 0

        // count the number of nodes in the first k nodes
        while (curr != null && count < k) {
            curr = curr.next
            count++
        }

        // if the number of nodes is less than k, return head
        if (count < k) {
            return head
        }

        // reverse the first k nodes
        val newHead = reverseList(head, k)

        // recursively call the function on the remaining nodes
        head!!.next = reverseKGroup(curr, k)
        return newHead
    }

    // helper function to reverse a linked list of length k
    private fun reverseList(head: ListNode?, k: Int): ListNode? {
        var k = k
        var prev: ListNode? = null
        var curr = head
        var next: ListNode? = null
        while (k > 0 && curr != null) {
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            k--
        }
        return prev
    }

    class ListNode {
        private var `val` = 0
        var next: ListNode? = null

        internal constructor()
        internal constructor(`val`: Int) {
            this.`val` = `val`
        }

        internal constructor(`val`: Int, next: ListNode?) {
            this.`val` = `val`
            this.next = next
        }
    }
}