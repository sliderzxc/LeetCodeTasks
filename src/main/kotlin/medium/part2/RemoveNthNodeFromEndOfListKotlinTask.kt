package medium.part2

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
class RemoveNthNodeFromEndOfListKotlinTask {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var p1: ListNode? = dummy
        var p2: ListNode? = dummy
        for (i in 0 until n) {
            p2 = p2!!.next
        }
        while (p2!!.next != null) {
            p1 = p1!!.next
            p2 = p2.next
        }
        p1!!.next = p1.next!!.next
        return dummy.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}