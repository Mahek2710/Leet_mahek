class Solution {
    public boolean isAnagram(String s, String t) {
        
        // ===== LENGTH CHECK =====
        // If lengths differ → impossible to be anagram
        // (because same characters count required)
        if(s.length() != t.length()){
            return false;
        }

        // ===== FREQUENCY ARRAY =====
        // Stores count of each character (a–z)
        // Index 0 → 'a', 1 → 'b', ..., 25 → 'z'
        int [] charCounts = new int[26]; // fixed size → O(1) space

        // ===== COUNTING =====
        // For same index i:
        // +1 for s[i]
        // -1 for t[i]
        // WHY?
        // → If both strings have same frequency,
        //   all values will cancel out to 0

        for(int i = 0 ; i < s.length() ; i++){  

            // Convert char to index using (char - 'a')
            // Example: 'c' - 'a' = 2
            charCounts[s.charAt(i) - 'a']++; 
            charCounts[t.charAt(i) - 'a']--;
        }

        // ===== VALIDATION =====
        // If any count != 0 → mismatch exists
        for(int count : charCounts){
            if(count != 0)
                return false;
        }

        // All counts balanced → valid anagram
        return true;
    }
}


/*
================= 🧠 PROBLEM THINKING =================

Anagram means:
- Same characters
- Same frequency

Brute Force:
- Sort both strings and compare → O(n log n) ❌

Optimized Thinking:
- Instead of sorting,
  count frequency of characters

👉 If frequencies match → anagram


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Check length
   → If different → return false immediately

2. Create array[26]
   → stores frequency of each character

3. Traverse both strings together:
   - Increment for s
   - Decrement for t

   WHY together?
   → Saves extra loop
   → Cancels out counts directly

4. Traverse array:
   - If any value ≠ 0 → mismatch → return false

5. Else → return true


================= 🔄 EXECUTION FLOW =================

Example:
s = "anagram"
t = "nagaram"


Initial:
charCounts = all 0


After processing:

a → +1 (s), -1 (t) → cancels
n → +1, -1 → cancels
g → +1, -1 → cancels
...

Final array:
[0,0,0,...,0]

→ All zero ✅


Example 2:
s = "rat"
t = "car"

r → +1
a → +1
t → +1

c → -1
a → -1
r → -1

Final:
t → +1 (extra)
c → -1 (missing)

→ Not all zero ❌ → return false


================= ⏱ TIME COMPLEXITY =================

O(n)

- Single pass through strings
- Second loop runs only 26 times → constant


================= 📦 SPACE COMPLEXITY =================

O(1)

- Array size fixed = 26
- Does not grow with input


================= 🎯 MEMORY LINE =================

"Increase for s, decrease for t → all zeros means anagram."

====================================================
*/