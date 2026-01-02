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
    public ListNode mergeKLists(ListNode[] lists) {

        // Min-heap to store all node values from all lists
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Push all values from all linked lists into the heap
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }

        // Dummy node to build the merged sorted list
        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        // Extract values from heap in sorted order
        // and create the merged linked list
        while (!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }

        // Return the head of the merged list
        return dummy.next;
    }
}
// Let N = total number of nodes across all lists
// Let k = number of linked lists

// TC: O(N log N)
// Inserting N elements into the heap and removing them one by one.

// SC: O(N)
// Heap stores all node values.

// 1. Create a min-heap to store values from all linked lists.
// 2. Traverse each linked list and add every node's value to the heap.
// 3. Create a dummy node to start the merged list.
// 4. Repeatedly remove the smallest value from the heap.
// 5. Create a new node with that value and attach it to the merged list.
// 6. Continue until the heap is empty.
// 7. Return dummy.next as the merged sorted list.
