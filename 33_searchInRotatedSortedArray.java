class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Standard binary search loop
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Case 1: Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Check if target lies outside the sorted left half
                if (target < nums[left] || target > nums[mid]) {
                    // Target must be in the right half
                    left = mid + 1;
                } else {
                    // Target lies within the sorted left half
                    right = mid - 1;
                }
            }

            // Case 2: Right half is sorted
            else {

                // Check if target lies outside the sorted right half
                if (target > nums[right] || target < nums[mid]) {
                    // Target must be in the left half
                    right = mid - 1;
                } else {
                    // Target lies within the sorted right half
                    left = mid + 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}


// TC: O(log n)
// Binary search with halved search space.

// SC: O(1)
// Only constant extra variables used.


// 1. Perform binary search on the rotated sorted array.
// 2. At every step, determine which half (left or right) is sorted.
// 3. If left half is sorted, check whether the target lies within it.
// 4. If not, discard the left half and search the right half.
// 5. If right half is sorted, check whether the target lies within it.
// 6. If not, discard the right half and search the left half.
// 7. Continue until the target is found or search space is empty.
//In a rotated sorted array, one half is always sorted.
//Decide which half is sorted, then check if the target belongs there. Identify the sorted half, then binary-search only where the target can exist.