/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // If they meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end → no cycle
        return false;
    }
}

// TC: O(n)
// SC: O(1)

// Step-by-step approach (Floyd’s Cycle Detection):
// 1. Use two pointers: slow and fast, both starting at the head.
// 2. Move slow by one step and fast by two steps in each iteration.
// 3. If there is a cycle, fast will eventually meet slow.
// 4. If fast reaches null or fast.next becomes null, no cycle exists.
// 5. Return true if pointers meet, otherwise return false.
