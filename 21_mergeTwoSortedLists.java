class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node to help build the merged list
        ListNode dummy = new ListNode(1);

        // Pointer used to connect nodes in the merged list
        ListNode merge = dummy;

        // Traverse both lists until one becomes null
        while (list1 != null && list2 != null) {

            // Compare current values of both lists
            if (list1.val <= list2.val) {
                // Attach node from list1
                merge.next = list1;
                list1 = list1.next;
            } else {
                // Attach node from list2
                merge.next = list2;
                list2 = list2.next;
            }

            merge = merge.next; //// Move the merge pointer forward
        }

        // After the loop, one list is exhausted

        // If list1 became null, attach list2
        if (merge.next == list1 && list1 == null) {
            merge.next = list2;
        }
        // Otherwise attach list1
        else {
            merge.next = list1;
        }

        // Return the merged list starting after dummy
        return dummy.next;
    }
}

// TC: O(n + m)
// Each node from both lists is processed once.

// SC: O(1)
// Merging is done in-place using pointers.


// 1. Create a dummy node to start the merged list.
// 2. Compare the current nodes of both lists.
// 3. Attach the smaller node to the merged list.
// 4. Move forward in the list from which the node was taken.
// 5. Move the merge pointer forward.
// 6. Once one list ends, attach the remaining nodes of the other list.
// 7. Return dummy.next as the head of the merged list.

//list1 → 1 → 3 → 5
// list2 → 2 → 4 → 6

// merge builds:
// dummy → 1 → 2 → 3 → 4 → 5 → 6

