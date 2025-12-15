class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Sort the array to use two-pointer technique
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // Fix the first element one by one   // nums[i] <= 0 Stop early once nums[i] becomes positive,
        // because three positive numbers can never sum to zero

        //If nums[i] > 0, then nums[left] and nums[right] are also > 0
        //So nums[i] + nums[left] + nums[right] > 0 always
        //→ No valid triplet possible beyond this point

        for (int i = 0; i < nums.length && nums[i] <= 0 ; i++) {

            // Skip duplicate values for the first element
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum2(nums, i, result);
            }
        }

        return result;
    }

    // Finds pairs nums[left] + nums[right] such that
    // nums[i] + nums[left] + nums[right] == 0
    void twoSum2(int[] nums, int i, List<List<Integer>> result) {

        int left = i + 1;              // Start just after i
        int right = nums.length - 1;   // End of array

        while (left < right) {

            int sum = nums[i] + nums[left] + nums[right];

            // If sum is too small, move left pointer right
            if (sum < 0) {
                left++;
            }
            // If sum is too large, move right pointer left
            else if (sum > 0) {
                right--;
            }
            // Found a valid triplet
            else {
                result.add(
                    Arrays.asList(nums[i], nums[left], nums[right])
                );

                left++;
                right--;

                // Skip duplicate values for the second element
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }
}



// TC: O(n^2)
// One loop for fixing nums[i] and a two-pointer scan for remaining elements.

// SC: O(1)
// No extra space used apart from the output list.

// 1. Sort the array so we can safely use the two-pointer technique.
// 2. Fix one number nums[i] as the first element of the triplet.
// 3. Skip duplicate values of nums[i] to avoid repeated triplets.
// 4. For the remaining part of the array, find two numbers whose sum is -nums[i].
// 5. Move pointers based on whether the current sum is too small or too large.
// 6. After finding a valid triplet, skip duplicate values for the second element.
// 7. Collect all unique triplets whose total sum is exactly zero.


//Fix one → Two pointers → Skip duplicates → Collect unique triplets