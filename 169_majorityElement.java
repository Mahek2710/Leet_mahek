class Solution {

    // Helper method to count frequency of each number
    private Map<Integer, Integer> countNums(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<>();

        // Count how many times each number appears
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        return counts;
    }

    public int majorityElement(int[] nums) {

        // Step 1: Build frequency map
        Map<Integer, Integer> counts = countNums(nums);

        // This will store the entry with the highest frequency
        Map.Entry<Integer, Integer> majorityEntry = null;

        // Step 2: Find the element with maximum count
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {

            // First entry OR found a higher frequency
            if (majorityEntry == null ||
                entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        // Step 3: Return the number (key) with highest frequency
        return majorityEntry.getKey();
    }
}


// TC: O(n)
// One pass to count frequencies + one pass to find max.

// SC: O(n)
// HashMap stores frequency of each unique number.

// 1. Traverse the array and build a HashMap that stores
//    each number along with how many times it appears.
// 2. Iterate over the HashMap entries to track the element
//    with the maximum frequency.
// 3. Return the key of the entry that has the highest count,
//    which is guaranteed to be the majority element.
