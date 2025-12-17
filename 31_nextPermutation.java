class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // 1. Find the first index from the right where nums[i] < nums[i + 1]
        //    This is the "break point" where we can make the permutation larger
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        // 2. If such a break point exists, find the smallest element
        //    on the right side that is greater than nums[i] and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. Reverse the part after index i to get the smallest possible suffix
        reverse(nums, i + 1);
    }

    // Swap elements at indices i and j
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse the array from index i to the end
    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

// TC: O(n)
// We scan the array from the right and reverse part of it.

// SC: O(1)
// All operations are done in-place.


// Key Intuition:
// We look for the first place from the right where the array stops decreasing.
// That position is where we can make the permutation slightly bigger.
// To keep the change minimal, we swap it with the smallest number greater than it on the right.
// Finally, we reverse the remaining suffix so it becomes the smallest possible arrangement.
// This guarantees the very next lexicographical permutation.
