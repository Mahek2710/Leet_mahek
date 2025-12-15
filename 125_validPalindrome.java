class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

// TC: O(n)
// Each character is visited at most once.

// SC: O(1)
// Only constant extra space is used.

// 1. Use two pointers starting from left and right.
// 2. Ignore non-alphanumeric characters.
// 3. Compare characters in lowercase.
// 4. If mismatch occurs, return false.
// 5. If all comparisons pass, return true.

