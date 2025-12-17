class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Edge case: empty input
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        // Compare prefix with each string
        for (int i = 1; i < strs.length; i++) {

            // Reduce prefix until it matches the start of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

// TC: O(n * m)
// n = number of strings, m = length of the prefix

// SC: O(1)
// No extra space used apart from variables


// Start by assuming the first string is the common prefix.
// Compare this prefix with each subsequent string.
// If the current string does not start with the prefix,
// keep shortening the prefix from the end.
// Continue until the prefix matches or becomes empty.
// The remaining prefix is the longest common prefix.
