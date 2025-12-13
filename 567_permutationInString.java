class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, permutation is impossible
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Build frequency map for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            // Check if current window is a permutation
            if (matches(s1Map, s2Map)) {
                return true;
            }

            // Add next character to window
            s2Map[s2.charAt(i + s1.length()) - 'a']++;

            // Remove leftmost character from window
            s2Map[s2.charAt(i) - 'a']--;
        }

        // Check the last window
        return matches(s1Map, s2Map);
    }

    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}

// TC: O(n)
// Sliding window over s2, comparing fixed-size (26) arrays.

// SC: O(1)
// Two frequency arrays of constant size (26).

// 1. If s1 is longer than s2, return false.
// 2. Build frequency arrays for s1 and the first window of s2.
// 3. Slide a window of size s1.length() over s2.
// 4. At each step, compare frequency arrays.
// 5. If they match, a permutation exists → return true.
// 6. If no window matches, return false.
