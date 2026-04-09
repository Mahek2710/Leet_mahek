class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // ===== EDGE CASE =====
        // If s1 is bigger, it can't fit in s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays
        int[] s1Map = new int[26];   // for s1
        int[] s2Map = new int[26];   // for window in s2

        int windowSize = s1.length();


        // ===== INITIAL WINDOW =====
        // Fill frequency for s1 and first window of s2
        for (int i = 0; i < windowSize; i++) {

            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }


        // ===== COUNT MATCHES =====
        // matches = how many letters (out of 26) have same count
        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) {
                matches++;
            }
        }


        int left = 0;   // start of window


        // ===== SLIDING WINDOW =====
        for (int right = windowSize; right < s2.length(); right++) {

            // If everything matches → permutation found
            if (matches == 26) {
                return true;
            }


            // ===== ADD RIGHT =====
            // New char enters window
            int index = s2.charAt(right) - 'a';
            s2Map[index]++;

            // Check if this made match better or worse
            if (s2Map[index] == s1Map[index]) {
                matches++;   // now equal
            } 
            else if (s2Map[index] == s1Map[index] + 1) {
                matches--;   // was equal, now extra
            }


            // ===== REMOVE LEFT =====
            // Old char leaves window
            index = s2.charAt(left) - 'a';
            s2Map[index]--;

            // Check again
            if (s2Map[index] == s1Map[index]) {
                matches++;   // now equal
            } 
            else if (s2Map[index] == s1Map[index] - 1) {
                matches--;   // was equal, now less
            }


            // Move window forward
            left++;
        }


        // ===== LAST WINDOW =====
        if (matches == 26) {
            return true;
        }

        return false;
    }
}

/*
================= 🧠 PROBLEM THINKING =================

We need to check:
→ Does ANY substring of s2 have same characters as s1?

Permutation = same frequency of characters

So instead of generating permutations ❌
→ Compare frequency using sliding window ✅


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. If s1 is bigger → return false

2. Create two arrays:
   s1Map → frequency of s1
   s2Map → frequency of current window

3. Fill initial window (size = s1.length())

4. Count matches:
   → how many of 26 chars have same freq

5. Slide window:
   - Check if matches == 26 → return true
   - Add right char
   - Remove left char
   - Update matches accordingly

6. Check last window


================= 🔄 EXECUTION FLOW =================

Example:
s1 = "ab"
s2 = "eidbaooo"

Window size = 2

Windows:
"ei" → no
"id" → no
"db" → no
"ba" → YES ✅

Return true


================= 🔑 CORE IDEA =================

Window size is fixed = s1.length()

At every step:
→ Compare window with s1 using frequency

Instead of comparing full arrays,
→ use matches variable


================= 🧠 MATCHES LOGIC =================

matches = number of characters (out of 26)
whose frequency matches in both arrays

If:
matches == 26 → all match → permutation found


================= 🔄 WINDOW MOVEMENT =================

Each step:

1. Add right character (new entry)
2. Remove left character (old exit)
3. Move left forward

Window stays same size always


================= ⏱ TIME COMPLEXITY =================

O(n)

- Sliding window over s2
- No full array comparison each time


================= 📦 SPACE COMPLEXITY =================

O(1)

- Only 2 arrays of size 26


================= 🎯 MEMORY LINE =================

"Add right, remove left, track matches."

====================================================
*/