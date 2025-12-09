class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // If there are no words given, there is nothing to group
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // This map will store:
        // key   → the "fingerprint" of letters (frequency pattern)
        // value → list of words that match that fingerprint
        Map<String, List<String>> ansMap = new HashMap<>();

        // This array is used to count how many times each letter appears (a to z)
        int[] count = new int[26];

        // Go through every word one by one
        for (String s : strs) {

            // Reset the letter count before processing a new word
            Arrays.fill(count, 0);

            // Count each character of the current word
            for (char c : s.toCharArray()) {
                count[c - 'a']++;   // map 'a'→0, 'b'→1, ..., 'z'→25
            }

            // Convert the frequency array into a unique String key
            // This key will be the same for all anagrams
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');      // separator so numbers don’t mix
                sb.append(count[i]);
            }

            String key = sb.toString();

            // If this pattern is seen for the first time, create a new group
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }

            // Add the current word to its correct anagram group
            ansMap.get(key).add(s);
        }

        // Finally, return only the grouped words (ignore the keys)
        return new ArrayList<>(ansMap.values());
    }
}


// TC: O(n * k)
// We go through all the words (n),
// and for each word we scan all its characters (k).

// SC: O(n)
// We store all the words inside the HashMap as groups.


// 1. First, we create a HashMap to store anagram groups.
// 2. For each word, we count how many times each letter appears.
// 3. We convert that letter count into a single unique String (pattern).
// 4. Words with the same pattern go into the same group.
// 5. If the pattern is new, we create a new group.
// 6. At the end, we return all the groups.
