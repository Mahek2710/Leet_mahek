class Solution {

    // Map to store values of Roman symbols (single and special pairs)
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);

        // Special subtractive combinations
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {

        int sum = 0;
        int i = 0;

        while (i < s.length()) {

            // Step 1: Check for 2-character combination (like IV, IX, etc.)
            if (i < s.length() - 1) {
                String twoSymbols = s.substring(i, i + 2);

                if (values.containsKey(twoSymbols)) {
                    sum += values.get(twoSymbols);
                    i += 2;   // Skip both characters
                    continue;
                }
            }

            // Step 2: Otherwise process single character
            String oneSymbol = s.substring(i, i + 1);
            sum += values.get(oneSymbol);
            i += 1;
        }

        return sum;
    }
}



// TC: O(n)
// We scan the string once, checking 1 or 2 characters at a time.

// SC: O(1)
// The map size is fixed (always the same 13 Roman mappings).


// 1. Create a map storing values for single letters and special pairs.
// 2. Loop through the string.
// 3. First check if the next two characters form a valid Roman pair.
// 4. If yes, add its value and skip 2 characters.
// 5. If not, add value of the single character and move 1 step.
// 6. Continue until the entire string is processed and return the sum.
