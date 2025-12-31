class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Edge cases: empty or single-character string
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int left = 0;   // start of sliding window
        int right = 0;  // end of sliding window
        int ans = 0;    // longest valid window length found so far

        // Stores characters currently inside the window
        HashSet<Character> set = new HashSet<>();

        // Expand the window by moving 'right'
        while (right < s.length()) {

            char c = s.charAt(right);

            // If character already exists,
            // move 'left' forward until duplicate is removed
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to window
            set.add(c);

            // Update maximum length of unique-character window
            ans = Math.max(ans, right - left + 1);

            // Move window forward
            right++;
        }

        return ans;
    }
}


// TC: O(n)
// Each character is added and removed from the set at most once.

// SC: O(n)
// HashSet stores at most all unique characters in the window.

// 1. Use a sliding window with two pointers (left and right).
// 2. Maintain a HashSet to store characters in the current window.
// 3. Expand the window by moving right.
// 4. If a duplicate character is found, shrink window from the left
//    until the duplicate is removed.
// 5. Track the maximum window size without duplicates.
// 6. Return the maximum length found.
