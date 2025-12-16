class Solution {
    public int removeDuplicates(int[] nums) {

        // insertIndex marks the position where the next unique element should go
        int insertIndex = 1;

        // Start from index 1 since the first element is always unique
        for (int i = 1; i < nums.length; i++) {

            // If current element is different from the previous one,
            // it means we found a new unique value
            if (nums[i] != nums[i - 1]) {

                // Place this unique value at the insertIndex position
                nums[insertIndex] = nums[i];

                // Move insertIndex forward for the next unique element
                insertIndex++;
            }
        }

        // insertIndex represents the length of the array with unique elements
        return insertIndex;
    }
}

// TC: O(n)
// Single pass through the array.

// SC: O(1)
// In-place modification, no extra space used.

// 1. Use one pointer to read through the array from left to right.
// 2. Use another pointer to mark the position where the next unique element should be written.
// 3. Since the array is sorted, compare each element with the previous one to detect duplicates.
// 4. When a new value appears, overwrite the array at the write position and move it forward.
// 5. The final write position tells how many unique elements the array contains.
