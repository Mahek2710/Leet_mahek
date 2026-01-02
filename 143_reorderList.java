/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        // Base check
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Step 3: Merge two halves
        ListNode first = head;
        ListNode second = prev;

        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}


// TC: O(n)
// We traverse the linked list multiple times (finding middle, reversing,
// and merging), but each node is processed a constant number of times.

// SC: O(1)
// All operations are done in-place using pointers.
// No extra data structures are used.



// 1. Find the middle of the linked list using slow and fast pointers.
// 2. Reverse the second half of the list.
// 3. Merge the first half and reversed second half alternately.
//    (first → last → second → second-last → ...)

