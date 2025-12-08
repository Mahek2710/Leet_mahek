class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k){

        Set<Integer> set = new HashSet<>();

        // Traverse the array
        for(int i = 0; i < nums.length; i++){

            // If number already exists within k range, duplicate found
            if(set.contains(nums[i])){
                return true;
            }

            // Add current number to the set
            set.add(nums[i]);

            // Maintain window size of k elements
            if(set.size() > k){
                set.remove(nums[i - k]); // Window aage badhao, peeche ka element hatao
            }
        }

        return false; // No nearby duplicates found
    }
}


// TC: O(n) - One pass through the array with O(1) average HashSet operations.
// SC: O(k) - At most k elements stored in the HashSet at any time.


// 1. Use a HashSet as a sliding window of size k.
// 2. Traverse the array.
// 3. If current number already exists in the set → return true.
// 4. Else, add the number to the set.
// 5. If window size exceeds k, remove the element that is k steps behind.
// 6. If loop finishes, return false.
