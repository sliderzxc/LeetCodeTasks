package medium.part2

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 ? L1 ? … ? Ln - 1 ? Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 ? Ln ? L1 ? Ln - 1 ? L2 ? Ln - 2 ? …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 */
class ReorderListKotlinTask {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reorderList(head: ListNode?) {
        if (head?.next == null) {
            return
        }

        // Step 1: find the middle node
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }

        // Step 2: reverse the second half
        var prev: ListNode? = null
        var curr = slow
        while (curr != null) {
            val next = curr.next!!
            curr.next = prev
            prev = curr
            curr = next
        }

        // Step 3: merge the two halves
        var first = head
        var second = prev
        while (second!!.next != null) {
            val nextFirst = first!!.next
            first.next = second
            first = nextFirst
            val nextSecond = second.next
            second.next = first
            second = nextSecond
        }
    }
}