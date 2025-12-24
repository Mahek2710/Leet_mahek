class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        // Initialize answer with the first element
        int ans = nums[0];

        // Edge case: only one element
        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {

            // If the current subarray is already sorted,
            // then the leftmost element is the minimum in this range
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
                break; // no need to search further
            }

            int mid = left + (right - left) / 2;

            // Update answer using mid element
            ans = Math.min(ans, nums[mid]);

            // Decide which half to search next
            if (nums[left] <= nums[mid]) {
                // Left half is sorted, so minimum must be in right half
                left = mid + 1;
            } else {
                // Right half is sorted, so minimum must be in left half
                right = mid - 1;
            }
        }

        return ans;
    }
}
// TC: O(log n)
// Binary search reduces the search space each step.

// SC: O(1)
// Only constant extra variables are used.

// 1. Use binary search since the array is sorted but rotated.
// 2. If the current range is already sorted, take the leftmost element as minimum.
// 3. Always compare mid element with the current answer.
// 4. Check which half is sorted using nums[left] and nums[mid].
// 5. Discard the sorted half and continue searching in the unsorted half.
// 6. Keep updating the minimum until the search ends.
