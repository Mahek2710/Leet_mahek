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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to build the result list
        ListNode dummy = new ListNode(0);

        // Pointer to build the answer list
        ListNode ans = dummy;

        // Carry from previous addition
        int carry = 0;

        // Continue while there are digits to process or carry remains
        while (l1 != null || l2 != null || carry != 0) {

            // Get current digit from each list (0 if list ended)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Add digits and carry
            int sum = x + y + carry;

            // Update carry for next iteration
            carry = sum / 10;

            // Store current digit in result list
            ans.next = new ListNode(sum % 10);
            ans = ans.next;

            // Move to next node in l1 if available
            if (l1 != null) {
                l1 = l1.next;
            }

            // Move to next node in l2 if available
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Result starts after dummy node
        return dummy.next;
    }
}


// TC: O(max(m, n))
// We traverse both linked lists once, processing one digit per node.

// SC: O(max(m, n))
// A new linked list is created to store the sum, which can have at most
// max(m, n) + 1 nodes due to carry.

// 1. Use a dummy node to simplify result list construction.
// 2. Traverse both lists digit by digit.
// 3. Add corresponding digits along with carry.
// 4. Store the last digit of the sum in the result list.
// 5. Carry over the remaining value.
// 6. Continue until both lists and carry are exhausted.
// 7. Return the result list.
