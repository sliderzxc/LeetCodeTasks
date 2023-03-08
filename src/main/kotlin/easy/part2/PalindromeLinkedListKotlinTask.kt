package easy.part2

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * <p>
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 */
class PalindromeLinkedListKotlinTask {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }
        var slow = head
        var fast = head
        while (fast!!.next != null && fast.next!!.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        var prev: ListNode? = null
        var curr = slow!!.next
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        var p1 = head
        var p2 = prev
        while (p2 != null) {
            if (p1!!.`val` != p2.`val`) {
                return false
            }
            p1 = p1.next
            p2 = p2.next
        }
        return true
    }

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}