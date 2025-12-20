class Solution {
    public int[] searchRange(int[] nums, int target) {

        // Find the first occurrence of target
        int first = findBound(nums, target, true);

        // If target never appears in the array
        if (first == -1) {
            return new int[]{-1, -1};
        }

        // Find the last occurrence of target
        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    // Helper binary search:
    // if isFirst = true  → find first position of target
    // if isFirst = false → find last position of target
    private int findBound(int[] nums, int target, boolean isFirst) {

        int start = 0;
        int end = nums.length - 1;

        // Stores the best index found so far
        int bound = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {

                // We found target, but we don't stop immediately
                // because we want the extreme (first or last)
                bound = mid;

                if (isFirst) {
                    // For first occurrence, keep searching on the left side
                    end = mid - 1;
                } else {
                    // For last occurrence, keep searching on the right side
                    start = mid + 1;
                }

            } 
            else if (nums[mid] < target) {
                // Target must be on the right side
                start = mid + 1;
            } 
            else {
                // Target must be on the left side
                end = mid - 1;
            }
        }

        // Will be -1 if target was never found
        return bound;
    }
}

// TC: O(log n)
// Binary search runs twice.

// SC: O(1)
// Only pointers and variables used.

// 1. Use binary search to locate the target.
// 2. When target is found, save the index but keep searching.
// 3. If finding the first occurrence, move search to the left side.
// 4. If finding the last occurrence, move search to the right side.
// 5. Return the extreme index found after the search completes.
