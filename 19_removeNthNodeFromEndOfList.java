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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node to handle edge cases (like removing the head)
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        // Two pointers starting from dummy
        ListNode front = dummy;
        ListNode back = dummy;

        // Move 'front' pointer (n + 1) steps ahead
        // This creates a gap of n nodes between front and back
        for (int i = 0; i <= n; i++) {
            front = front.next;
        }

        // Move both pointers until front reaches the end
        // At this point, back is just before the node to be removed
        while (front != null) {
            front = front.next;
            back = back.next;
        }

        // Remove the nth node from the end
        back.next = back.next.next;

        // Return the updated list (skip dummy node)
        return dummy.next;
    }
}
// TC: O(n)
// SC: O(1)

// 1. Add a dummy node before the head to simplify deletion.
// 2. Use two pointers starting at the dummy node.
// 3. Move the front pointer n+1 steps ahead to create a fixed gap.
// 4. Move both pointers together until front reaches null.
// 5. Back pointer now points to the node just before the target.
// 6. Skip (delete) the target node.
// 7. Return the list starting from dummy.next.
