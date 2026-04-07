class Solution {

    // Map to store values of Roman symbols
    // Includes both:
    // 1) Single symbols → I, V, X...
    // 2) Special subtractive pairs → IV, IX...
    static Map<String, Integer> values = new HashMap<>();

    static {
        // ===== SINGLE SYMBOLS =====
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);

        // ===== SUBTRACTIVE CASES =====
        // These are the only cases where smaller comes before bigger
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {

        int sum = 0;   // stores final integer result
        int i = 0;     // pointer to traverse the string

        // Traverse the string from left to right
        while (i < s.length()) {

            // ===== TRY TO TAKE 2 CHARACTERS =====
            // Check if we can form a substring of length 2
            if (i < s.length() - 1) {

                // Extract current + next character
                String twoSymbols = s.substring(i, i + 2);

                // If this pair is a valid subtractive case
                if (values.containsKey(twoSymbols)) {

                    // Add its mapped value (like IV → 4)
                    sum += values.get(twoSymbols);

                    // Skip BOTH characters since we used them
                    i += 2;

                    // Move to next iteration (skip single char logic)
                    continue;
                }
            }

            // ===== TAKE SINGLE CHARACTER =====
            // If no valid pair, process one character

            String oneSymbol = s.substring(i, i + 1);

            // Add its value (like V → 5)
            sum += values.get(oneSymbol);

            // Move to next character
            i += 1;
        }

        // Final computed integer
        return sum;
    }
}

/*
================= 🧠 PROBLEM UNDERSTANDING =================

Roman numerals follow 2 rules:

1. Normal case → ADD values
   Example: VI = 5 + 1 = 6

2. Subtractive case → SMALL before BIG → SUBTRACT
   Example: IV = 5 - 1 = 4

👉 These subtractive cases are FIXED:
   IV, IX, XL, XC, CD, CM


================= ⚙️ APPROACH OVERVIEW =================

Idea:
- Traverse the string from left to right
- At each step, decide:

   👉 "Should I take 1 character or 2?"

Steps:

1. Store values in a map:
   - Single symbols → I, V, X, ...
   - Special pairs → IV, IX, ...

2. Loop through string using index i

3. At each position:
   a) Check if substring(i, i+2) exists in map
      → If YES:
           add its value
           move i by 2

   b) Otherwise:
           take single character
           move i by 1

4. Keep adding to sum


================= 🔑 KEY INSIGHT =================

Always TRY to match 2 characters FIRST

Why?
→ Because subtractive cases must be handled before single ones

👉 If you process single first, you'll get wrong results


================= 🔄 DRY RUN =================

Example:
s = "MCMIV"


Step 1:
i = 0 → "MC" not special
→ take 'M' = 1000
sum = 1000


Step 2:
i = 1 → "CM" special ✅
→ add 900
sum = 1900
i += 2


Step 3:
i = 3 → "IV" special ✅
→ add 4
sum = 1904


Final Answer:
1904


================= ⏱ TIME COMPLEXITY =================

O(n)

- Each character processed once
- Sometimes we skip 2 characters


================= 📦 SPACE COMPLEXITY =================

O(1)

- Map size is constant (fixed Roman symbols)


================= 🎯 ONE-LINE INTUITION =================

"At each step, take 2 chars if valid, otherwise take 1."

====================================================
*/
