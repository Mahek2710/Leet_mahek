class Solution {
    public String longestPalindrome(String s) {

        // Edge case: empty string
        if (s == null || s.length() < 1) {
            return "";
        }

        // These will store the start and end indices
        // of the longest palindrome found so far
        int left = 0;
        int right = 0;

        // Try every index as a possible center
        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome (single center)
            int len1 = checkPalindrome(s, i, i);

            // Even-length palindrome (center between two characters)
            int len2 = checkPalindrome(s, i, i + 1);

            // Take the longer one from both cases
            int len = Math.max(len1, len2);

            // If this palindrome is longer than the previous best,
            // update left and right boundaries
            if (len > right - left + 1) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            } 
        }

        // Return the longest palindromic substring
        return s.substring(left, right + 1);
    }

    // Expands around the given center and returns
    // the length of the palindrome found
    public int checkPalindrome(String s, int left, int right) {

        int L = left;
        int R = right;

        // Expand outward as long as characters match
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        // When the loop stops, L and R are one step beyond the palindrome
        return R - L - 1;
    }
}

// TC: O(n²)
// For each index, we may expand across the string.

// SC: O(1)
// Only constant extra variables are used.

// 1. Treat every index as a possible center of a palindrome.
// 2. Expand around that center for both odd and even length cases.
// 3. Get the maximum palindrome length at each center.
// 4. Convert the length into left and right indices.
// 5. Keep updating the longest palindrome found.
// 6. Return the substring defined by those indices.
