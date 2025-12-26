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

    // Main function that applies merge sort on the linked list
    public ListNode sortList(ListNode head) {

        // Base case:
        // If the list is empty or has only one node,
        // it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    // Finds the middle of the linked list and splits it into two parts
    private ListNode getMid(ListNode head) {

        // prev will lag behind the fast pointer
        // It helps us cut the list into two halves
        ListNode prev = null;

        // Fast pointer moves 2 steps at a time
        // Slow pointer (tracked using prev) moves 1 step
        while (head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }

        // prev.next is the start of the second half
        ListNode mid = prev.next;

        // Cut the list into two independent lists
        prev.next = null;

        // Return head of the right half
        return mid;
    }

    // Merges two sorted linked lists into one sorted list
    private ListNode merge(ListNode list1, ListNode list2) {

        // Dummy node simplifies edge cases
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Compare nodes from both lists and attach the smaller one
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            // Move tail forward after attaching a node
            tail = tail.next;
        }

        // One list may still have remaining nodes
        // Attach them directly since they are already sorted
        tail.next = (list1 != null) ? list1 : list2;

        // dummy.next is the head of the merged sorted list
        return dummy.next;
    }
}


// TC: O(n log n)
// The list is split log n times, and each merge takes O(n).

// SC: O(log n)
// Recursion stack space (merge is in-place).


// 1. If the list has 0 or 1 node, return it (already sorted).
// 2. Find the middle of the list using fast/slow pointer logic.
// 3. Cut the list into two independent halves.
// 4. Recursively sort the left half.
// 5. Recursively sort the right half.
// 6. Merge the two sorted halves using a dummy node.
// 7. Return the merged sorted list.


//Linked list sorting = Merge Sort
// Why?
// - No random access → quicksort not ideal
// - Easy to split using pointers
// - Easy to merge in sorted order
