class Solution {
    public void sortColors(int[] nums) {

        // low     → boundary for RED (0)
        // current → pointer exploring the array
        // high    → boundary for BLUE (2)
        //
        // Invariant during the algorithm:
        // [0 ... low-1]      → all RED (0)
        // [low ... current-1]→ all WHITE (1)
        // [current ... high] → unknown (to be processed)
        // [high+1 ... end]   → all BLUE (2)
        int low = 0;
        int current = 0;
        int high = nums.length - 1;

        // Process elements until all unknowns are handled
        while (current <= high) {

            // If we see RED (0),
            // it belongs to the leftmost region
            if (nums[current] == 0) {
                swap(nums, current, low);

                // Expand RED region and move forward
                low++;
                current++;
            }

            // If we see BLUE (2),
            // it belongs to the rightmost region
            else if (nums[current] == 2) {
                swap(nums, current, high);

                // Shrink BLUE region
                // (do NOT move current, because swapped value is unprocessed)
                high--;
            }

            // If we see WHITE (1),
            // it already belongs in the middle
            else {
                current++;
            }
        }
    }

    // Swaps two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// TC: O(n)
// Each element is examined at most once.

// SC: O(1)
// In-place sorting using pointers only.


// (Dutch National Flag):
// 1. Treat 0 as RED, 1 as WHITE, and 2 as BLUE.
// 2. Maintain three regions: REDs on the left, WHITEs in the middle, BLUES on the right.
// 3. Use a pointer to scan the array through the unknown region.
// 4. When RED (0) is found, swap it into the RED region and move forward.
// 5. When BLUE (2) is found, swap it into the BLUE region and recheck the current position.
// 6. When WHITE (1) is found, leave it in place and continue.
// 7. Continue until all elements are placed in their correct color regions.
