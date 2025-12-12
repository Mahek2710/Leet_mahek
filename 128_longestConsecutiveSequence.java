class Solution {
    public int longestConsecutive(int[] nums) {

        // If array is empty, no sequence exists
        if (nums.length == 0) {
            return 0;
        }

        // Store all numbers in a HashSet for O(1) lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        // Check each number only if it is the start of a sequence
        for (int num : numSet) {

            // If (num - 1) exists, this number is not the start → skip
            if (numSet.contains(num - 1)) {
                continue;
            }

            // Otherwise, this is the start of a sequence
            int currentNum = num;
            int currentSub = 1;

            // Count how long the consecutive sequence continues
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentSub++;
            }

            // Update longest streak found so far
            longestSub = Math.max(longestSub, currentSub);
        }

        return longestSub;
    }
}

// TC: O(n)
// Each number is visited once, and HashSet lookups are O(1).
// Even the inner while loop overall processes each number only once.

// SC: O(n)
// The HashSet stores all unique numbers.


// 1. Add all numbers to a HashSet for fast lookup.
// 2. Only start counting when the number is the *start* of a sequence,
//    meaning (num - 1) is NOT in the set.
// 3. From this starting point, count how long the consecutive sequence continues.
// 4. Track the longest sequence length found.
// 5. Return the longest length.
