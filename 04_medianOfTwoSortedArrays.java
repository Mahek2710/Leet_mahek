class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        // This guarantees O(log(min(n, m))) time
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length; // size of smaller array
        int y = nums2.length; // size of larger array

        int start = 0;
        int end = x;

        // Binary search on nums1
        while (start <= end) {

            // Partition nums1 at partX
            int partX = (start + end) / 2;

            // Partition nums2 such that
            // left halves together contain (x + y + 1) / 2 elements
            int partY = (x + y + 1) / 2 - partX;

            // Handle edge cases using -∞ and +∞
            int xLeft  = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int xRight = (partX == x) ? Integer.MAX_VALUE : nums1[partX];

            int yLeft  = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int yRight = (partY == y) ? Integer.MAX_VALUE : nums2[partY];

            // Check if we found the correct partition
            if (xLeft <= yRight && yLeft <= xRight) {

                // Case 1: Total length is even
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(xLeft, yLeft)
                           + Math.min(xRight, yRight)) / 2;
                }
                // Case 2: Total length is odd
                else {
                    return Math.max(xLeft, yLeft);
                }
            }

            // Too many elements taken from nums1 → move left
            else if (xLeft > yRight) {
                end = partX - 1;
            }

            // Too few elements taken from nums1 → move right
            else {
                start = partX + 1;
            }
        }

        // Problem guarantees a valid answer
        return 0;
    }
}

// TC: O(log(min(n, m)))
// Binary search on the smaller array.

// SC: O(1)
// No extra space used.


// 1. Always binary search on the smaller array.
// 2. Choose a partition in the first array.
// 3. Deduce the partition in the second array so left side has half elements.
// 4. Compare border elements around the partitions.
// 5. If partition is correct:
//      - Even length → average of middle two.
//      - Odd length  → max of left side.
// 6. If not correct, adjust binary search range.
// 7. Repeat until correct partition is found.
