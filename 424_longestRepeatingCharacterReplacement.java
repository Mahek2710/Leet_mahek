class Solution {
    public int characterReplacement(String s, int k) {

        // Frequency of characters in current window
        int[] occurance = new int[26];

        int left = 0;          // start of window
        int ans = 0;           // max length of valid window
        int maxOccurance = 0;  // highest frequency of any char in window


        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            // ===== ADD RIGHT CHARACTER =====
            // Increase frequency of current char
            int index = s.charAt(right) - 'A';
            occurance[index]++;

            // Update max frequency seen in window
            maxOccurance = Math.max(maxOccurance, occurance[index]);


            // ===== CHECK WINDOW VALIDITY =====
            // Window size = (right - left + 1)
            // Changes needed = window size - maxOccurance
            // If changes > k → shrink window
            if (right - left + 1 - maxOccurance > k) {

                // Remove left character
                occurance[s.charAt(left) - 'A']--;
                left++;
            }


            // ===== UPDATE ANSWER =====
            // Keep track of largest valid window
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}

/*
================= 🧠 PROBLEM THINKING =================

We can replace at most k characters.

Goal:
→ Find longest substring where all chars can become SAME

Key Idea:
→ Make all characters equal to the MOST frequent one


================= ⚙️ CODE FLOW =================

1. Use sliding window [left ... right]

2. Track frequency of characters

3. Keep maxOccurance = highest freq in window

4. If:
   (window size - maxOccurance) > k
   → too many changes needed → shrink window

5. Update max window size


================= 🔑 CORE IDEA =================

window size - maxOccurance = changes needed

Example:
"AAABBC"
maxOccurance = 3 (A)

window size = 6
changes needed = 6 - 3 = 3


================= 🔄 WINDOW FLOW =================

Every step:

1. Add right character
2. Check if valid
3. If not → remove left
4. Update answer


================= 🔄 EXECUTION EXAMPLE =================

s = "AABABBA", k = 1

Try to make window all same:

Best window = "AABA" → length = 4


================= ⏱ TIME COMPLEXITY =================

O(n)

- Each char processed once


================= 📦 SPACE COMPLEXITY =================

O(1)

- Fixed array of size 26


================= 🎯 MEMORY LINE =================

"Window size - maxFreq ≤ k"

====================================================
*/