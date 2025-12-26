class Solution {
    public String largestNumber(int[] nums) {

        // Step 1: Convert all integers to strings
        // Reason: We need string concatenation comparisons, not numeric ones
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort using a custom comparator
        // We decide order based on which concatenation forms a larger number:
        // For strings a and b, compare (b + a) vs (a + b)
        Arrays.sort(asStrs, new Comparator<String>() {
            public int compare(String a, String b) {

                String order1 = a + b; // a followed by b
                String order2 = b + a; // b followed by a

                // Sort in descending order so the largest combination comes first
                return order2.compareTo(order1);
            }
        });

        // Step 3: Edge case
        // If the largest value is "0", then all values are "0"
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Step 4: Concatenate all sorted strings to form the answer
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}


// TC: O(n log n)
// Sorting n elements with custom comparison.

// SC: O(n)
// Extra space for string array and StringBuilder.

// 1. Convert all numbers to strings for easy concatenation.
// 2. Sort strings using a custom comparator.
// 3. For any two strings a and b, place the one first that forms
//    a larger number when concatenated.
// 4. Handle the edge case where all numbers are zero.
// 5. Join all sorted strings to form the largest possible number.
