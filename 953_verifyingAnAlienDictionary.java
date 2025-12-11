class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Map each alien character to its position in the custom order
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        // Compare each word with the next one
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            // Compare characters of both words
            for (int j = 0; j < w1.length(); j++) {

                // If w2 ends earlier but shares prefix with w1 → not sorted w1 = "batman" w2 = "bat" will ret false

                if (j >= w2.length()) {
                    return false;
                }

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                // If letters differ, compare their alien ordering
                if (c1 != c2) {
                    int pos1 = orderMap.get(c1);
                    int pos2 = orderMap.get(c2);

                    // If w1's letter comes AFTER w2's letter → wrong order
                    if (pos1 > pos2) {
                        return false;
                    }

                    // If correct order, move to next pair of words
                    break;
                }
            }
        }

        // All word pairs were in valid order
        return true;
    }
}


// TC: O(n * m)
// n = number of words, m = average word length.
// We compare each word with its next one, letter by letter.

// SC: O(1)
// The order map has a fixed size of 26 entries, regardless of input size.


// 1. Build a map assigning each alien letter its position (rank).
// 2. Compare each adjacent pair of words.
// 3. Compare letters at each position in the two words.
// 4. If letters differ, use the map to check alien ordering.
// 5. If second word is shorter but has same prefix → return false.
// 6. If none of the pairs violate the order, return true.
