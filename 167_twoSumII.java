class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            // If sum is greater than target, move right pointer left
            if (sum > target) {
                right--;
            }
            // If sum is smaller than target, move left pointer right
            else if (sum < target) {
                left++;
            }
            // Found the target sum
            else {
                return new int[]{left + 1, right + 1}; //Return 1-based indices as required by the ps 
            }
        }

        return null; // As per problem constraints, this will never be reached
    }
}

// TC: O(n)
// Two pointers move across the array once.

// SC: O(1)
// No extra space is used.

// 1. Use two pointers: left at start, right at end.
// 2. Calculate sum of values at both pointers.
// 3. If sum > target, move right pointer left.
// 4. If sum < target, move left pointer right.
// 5. If sum == target, return indices (1-based).
