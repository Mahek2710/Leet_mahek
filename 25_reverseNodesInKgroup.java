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
    public ListNode reverseKGroup(ListNode head, int k) {

        // Pointer used to check if there are at least k nodes left
        ListNode ptr = head;

        // ktail keeps track of the tail of the previous reversed group
        ListNode ktail = null;

        // newHead will store the head of the final modified list
        ListNode newHead = null;

        // Continue processing until we run out of nodes
        while (ptr != null) {

            int count = 0;
            ptr = head;

            // Check if there are k nodes available to reverse
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            // If we found exactly k nodes, reverse them
            if (count == k) {

                // Reverse k nodes starting from head
                ListNode revHead = reverseLinkedList(head, k);

                // Set newHead for the first reversed group
                if (newHead == null) {
                    newHead = revHead;
                }

                // Connect previous group with the current reversed group
                if (ktail != null) {
                    ktail.next = revHead;
                }

                // After reversal, head becomes the tail of this group
                ktail = head;

                // Move head to the next group
                head = ptr;
            }
        }

        // Attach the remaining nodes (less than k) as is
        if (ktail != null) {
            ktail.next = head;
        }

        // If no group was reversed, return original head
        return newHead == null ? head : newHead;
    }

    // Helper function to reverse exactly k nodes
    public ListNode reverseLinkedList(ListNode head, int k) {

        ListNode newHead = null;
        ListNode ptr = head;

        // Reverse k nodes using standard pointer reversal
        while (k > 0) {
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;
            k--;
        }

        // Return the new head of the reversed segment
        return newHead;
    }
}
// TC: O(n)
// Each node is visited a constant number of times.

// SC: O(1)
// Reversal is done in-place using pointers.

// 1. Traverse the list group by group.
// 2. For each group, check if at least k nodes exist.
// 3. If yes, reverse exactly k nodes.
// 4. Connect the reversed group with the previous one.
// 5. Keep track of the tail of the last reversed group.
// 6. Leave the remaining nodes (less than k) untouched.
// 7. Return the new head of the modified list.
