class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // p1 → last valid element in nums1
        // p2 → last element in nums2
        // i  → position to fill in nums1 (from the end)
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;

        // Fill nums1 from the back while nums2 still has elements
        while (p2 >= 0) {

            // If nums1 still has elements and its current value is larger,
            // place it at the current position
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            }
            // Otherwise, place element from nums2
            else {
                nums1[i] = nums2[p2];
                p2--;
            }

            // Move to the next position from the end
            i--;
        }
    }
}


// TC: O(m + n)
// Each element from nums1 and nums2 is processed once.

// SC: O(1)
// Merge is done in-place.


// 1. Start comparing from the end of both arrays.
// 2. Place the larger element at the end of nums1.
// 3. Move the corresponding pointer backward.
// 4. Continue until all elements of nums2 are placed.
// 5. nums1 is now fully merged and sorted.
