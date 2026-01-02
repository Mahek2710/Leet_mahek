class Solution {
    public int findDuplicate(int[] nums) {

        // Phase 1: Detect the cycle
        // Treat the array as a linked list where:
        // next = nums[currentIndex]

        int slow = nums[0];           // moves one step
        int fast = nums[nums[0]];     // moves two steps

        // If there is a duplicate, a cycle must exist
        while (slow != fast) {
            slow = nums[slow];        // move 1 step
            fast = nums[nums[fast]];  // move 2 steps
        }

        // Phase 2: Find the entry point of the cycle
        // Reset slow to the start of the "list"
        slow = 0;

        // Move both pointers one step at a time
        // They will meet at the cycle entry
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // The meeting point is the duplicate number
        return slow;
    }
}

// TC: O(n)
// Each pointer traverses the array at most a few times.

// SC: O(1)
// No extra space used; everything is done in-place.

// 1. Treat nums[] as a linked list using nums[i] as next pointer.
// 2. Use slow & fast pointers to detect a cycle.
// 3. Reset slow to start after cycle detection.
// 4. Move both pointers at same speed.
// 5. Where they meet again is the duplicate number.
