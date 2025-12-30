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
    public ListNode reverseList(ListNode head) {

        // prev will become the new head of the reversed list
        ListNode prev = null;

        // curr is used to traverse the original list
        ListNode curr = head;

        // Traverse the list until all nodes are reversed
        while (curr != null) {

            // Store the next node before breaking the link
            ListNode temp = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev one step forward
            prev = curr;

            // Move curr one step forward using the stored reference
            curr = temp;
        }

        // prev now points to the new head of the reversed list
        return prev;
    }
}

// TC: O(n)
// Each node is visited once.

// SC: O(1)
// Reversal is done in-place.

// 1. Initialize prev as null and curr as head.
// 2. Save curr.next before changing pointers.
// 3. Reverse curr.next to point to prev.
// 4. Move prev and curr forward.
// 5. Repeat until curr becomes null.
// 6. Return prev as the new head.
//Before:  1 → 2 → 3 → null
//After:   null ← 1 ← 2 ← 3

//1. temp = curr.next     (save future)
// 2. curr.next = prev     (reverse arrow)
// 3. prev = curr          (grow reversed list)
// 4. curr = temp          (move ahead)

