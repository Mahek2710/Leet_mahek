class Solution {
    public int countSubstrings(String s) {

        int ans = 0;

        // Try every index as a possible center
        for (int i = 0; i < s.length(); i++) {

            // Count odd-length palindromes (center at i)
            ans += checkPalindrome(s, i, i);

            // Count even-length palindromes (center between i and i+1)
            ans += checkPalindrome(s, i, i + 1);
        }

        return ans;
    }

    // Expands around the given center and counts palindromes
    public int checkPalindrome(String s, int left, int right) {

        int count = 0;

        // Expand as long as characters match and indices are valid
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            // Found one valid palindrome
            count++;

            // Expand outward to check larger palindrome
            left--;
            right++;
        }

        return count;
    }
}

// TC: O(n²)
// For each index, we expand outward in the worst case.

// SC: O(1)
// Only pointers and counters are used.

// 1. Treat every index as the center of a palindrome.
// 2. Expand from (i, i) to count odd-length palindromes.
// 3. Expand from (i, i+1) to count even-length palindromes.
// 4. Each successful expansion adds one palindromic substring.
// 5. Sum up counts from all centers and return the total.
