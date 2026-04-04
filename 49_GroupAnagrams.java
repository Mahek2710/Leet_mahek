class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // If there are no words given, there is nothing to group
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Map:
        // key   → frequency pattern (acts like fingerprint)
        // value → list of anagrams matching that pattern
        Map<String, List<String>> ansMap = new HashMap<>();

        // Array to store frequency of characters (a–z)
        int[] count = new int[26];

        // Traverse each word
        for (String s : strs) {

            // Reset count array for new word
            // WHY?
            // → Each word needs fresh frequency calculation
            Arrays.fill(count, 0);

            // Count characters of current word
            for (char c : s.toCharArray()) {
                count[c - 'a']++;   // map char to index (0–25)
            }

            // ===== BUILD KEY =====
            // Convert frequency array into unique string
            // WHY?
            // → Same frequency → same key → grouped together

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');        // separator to avoid ambiguity
                sb.append(count[i]);  // frequency of each char
            }

            String key = sb.toString();

            // ===== GROUPING =====
            // If key not present → create new group
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }

            // Add current word to its group
            ansMap.get(key).add(s);
        }

        // Return all grouped anagrams
        return new ArrayList<>(ansMap.values());
    }
}


/*
================= 🧠 PROBLEM THINKING =================

Goal:
- Group words which are anagrams

Key Observation:
- Anagrams have SAME character frequency

Brute Force:
- Compare every pair → O(n^2 * k) ❌

Better:
- Sort each word → O(n * k log k)

Optimal:
- Use frequency as identity (fingerprint)


================= ⚙️ CODE FLOW (HOW + WHY) =================

1. Create HashMap:
   key → frequency pattern
   value → list of words

2. For each word:
   a) Count characters using array[26]

   b) Convert array into String key
      → ensures same anagrams get same key

   c) If key not present → create new list

   d) Add word to that list

3. Return all groups


================= 🔑 KEY CREATION (MOST IMPORTANT) =================

Example:
word = "eat"

count array:
a=1, e=1, t=1 → rest 0

key = "#1#0#0#0#1#0...#1..."

Now:
"tea" → SAME key
"ate" → SAME key

👉 So all go in same group


WHY '#' separator?
- Without it:
  [1,11] and [11,1] → both "111" ❌
- With '#':
  "#1#11" vs "#11#1" ✅ different


================= 🔄 EXECUTION FLOW =================

Example:
strs = ["eat","tea","tan","ate","nat","bat"]


Step 1:
"eat" → key1 → map = {key1: ["eat"]}

Step 2:
"tea" → key1 → map = {key1: ["eat","tea"]}

Step 3:
"tan" → key2 → map = {key1: [...], key2: ["tan"]}

Step 4:
"ate" → key1 → ["eat","tea","ate"]

Step 5:
"nat" → key2 → ["tan","nat"]

Step 6:
"bat" → key3 → ["bat"]


Final Output:
[["eat","tea","ate"], ["tan","nat"], ["bat"]]


================= ⏱ TIME COMPLEXITY =================

O(n * k)

- n = number of words
- k = length of each word
- Counting characters takes O(k)


================= 📦 SPACE COMPLEXITY =================

O(n)

- Storing all words in hashmap groups


================= 🎯 MEMORY LINE =================

"Same frequency → same key → same group."

====================================================
*/