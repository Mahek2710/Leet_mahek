class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Standard binary search
        while (left <= right) {

            // Prevents overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }
            // Target lies in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // Target lies in the left half
            else {
                right = mid - 1;
            }
        }

        // Target not present in the array
        return -1;
    }
}

// TC: O(log n)
// Search space is halved at each step.

// SC: O(1)
// No extra space used.

// 1. Start with left and right pointers at array ends.
// 2. Find the middle element safely.
// 3. If middle equals target, return index.
// 4. If target is larger, search right half.
// 5. If target is smaller, search left half.
// 6. Repeat until found or search space is empty.
