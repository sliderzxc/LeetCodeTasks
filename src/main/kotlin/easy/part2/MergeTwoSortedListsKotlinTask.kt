package easy.part2

/**
You are given the heads of two sorted linked lists list1 and list2. Merge the two lists in a one sorted list. The
list should be made by splicing together the nodes of the first two lists. Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */
class MergeTwoSortedListsKotlinTask {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var curr1 = l1
        var curr2 = l2
        val dummy = ListNode(-1)
        var curr = dummy

        while (curr1 != null && curr2 != null) {
            if (curr1.`val` <= curr2.`val`) {
                curr.next = curr1
                curr1 = curr1.next
            } else {
                curr.next = curr2
                curr2 = curr2.next
            }
            curr = curr.next!!
        }

        if (curr1 != null) curr.next = curr1
        if (curr2 != null) curr.next = curr2

        return dummy.next
    }
}