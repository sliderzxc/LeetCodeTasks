package easy.part2;

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
public class PalindromeLinkedListJavaTask {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode p1 = head;
        ListNode p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}