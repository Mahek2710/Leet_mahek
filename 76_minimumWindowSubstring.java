class Solution {
    public String minWindow(String s, String t) {

        // Edge cases: impossible to form window
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Frequency map of characters required from t
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t that must be satisfied
        int required = mapT.size();

        // Number of characters currently satisfied in the window
        int formed = 0;

        // Sliding window pointers
        int left = 0, right = 0;

        // Answer format: {window length, left index, right index}
        int[] ans = {-1, 0, 0};

        // Frequency map for current window
        Map<Character, Integer> windowMap = new HashMap<>();

        // Expand the window using right pointer
        while (right < s.length()) {

            char c = s.charAt(right);

            // Add current character to window frequency
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If current character satisfies its required frequency
            if (mapT.containsKey(c) &&
                windowMap.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            // Try shrinking the window when all requirements are met
            while (left <= right && formed == required) {

                // Update answer if current window is smaller
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the leftmost character from window
                char lc = s.charAt(left);
                windowMap.put(lc, windowMap.get(lc) - 1);

                // If removing breaks a required condition, decrease formed
                if (mapT.containsKey(lc) &&
                    windowMap.get(lc).intValue() < mapT.get(lc).intValue()) {
                    formed--;
                }

                // Move left pointer to shrink window
                left++;
            }

            // Move right pointer to expand window
            right++;
        }

        // If no valid window found, return empty string
        if (ans[0] == -1) {
            return "";
        }

        // Return the minimum window substring
        return s.substring(ans[1], ans[2] + 1);
    }
}


// TC: O(n)
// Each character is processed at most twice (once by right, once by left).

// SC: O(1)
// HashMaps store at most all alphabet characters (bounded).

// 1. Store frequency of characters from t in a map.
// 2. Expand window using right pointer and update window frequencies.
// 3. Track how many required characters are fully satisfied.
// 4. When all requirements are met, shrink window from left.
// 5. Update the smallest valid window during shrinking.
// 6. Continue until the entire string is processed.
// 7. Return the smallest valid window found.
