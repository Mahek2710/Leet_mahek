class Solution {
    public int characterReplacement(String s, int k) {

        int[] occurance = new int[26];
        int left = 0;
        int ans = 0;
        int maxOccurance = 0;

        for (int right = 0; right < s.length(); right++) {

            // Include current character in the window
            maxOccurance = Math.max(
                maxOccurance,
                ++occurance[s.charAt(right) - 'A']
            );

            // If replacements needed exceed k, shrink window
            if (right - left + 1 - maxOccurance > k) {
                occurance[s.charAt(left) - 'A']--;
                left++;
            }

            // Update maximum valid window size
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}


// TC: O(n)
// Sliding window where each character is processed once.

// SC: O(1)
// Fixed-size frequency array of 26 uppercase letters.


// 1. Use a sliding window with two pointers (left and right).
// 2. Keep a frequency array for characters inside the window.
// 3. Track the count of the most frequent character in the window.
// 4. If (window size - maxOccurance) > k, shrink the window from the left.
// 5. Keep updating the maximum valid window size.
// 6. Return the largest window length found.
