import java.util.*;

class Solution {

    // Graph: character → list of next characters
    Map<Character, List<Character>> reversedList = new HashMap<>();

    // Track visited state:
    // false = visiting (cycle detection)
    // true = visited completely
    Map<Character, Boolean> seen = new HashMap<>();

    // Final result (topological order)
    StringBuilder output = new StringBuilder();


    public String alienOrder(String[] words) {

        // ===== STEP 1: INITIALIZE GRAPH =====
        // Add all characters as keys
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reversedList.putIfAbsent(c, new ArrayList<>());
            }
        }


        // ===== STEP 2: BUILD GRAPH =====
        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            String word1 = words[i];
            String word2 = words[i + 1];


            // Edge case:
            // ["abc", "ab"] → invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }


            // Compare characters
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {

                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                // First mismatch → ordering found
                if (c1 != c2) {

                    // c2 → c1 (reverse graph)
                    reversedList.get(c2).add(c1);

                    break; // only first difference matters
                }
            }
        }


        // ===== STEP 3: DFS ON ALL NODES =====
        for (char c : reversedList.keySet()) {

            // If cycle found → return ""
            if (!dfs(c)) {
                return "";
            }
        }


        // ===== STEP 4: CHECK VALID RESULT =====
        // If not all characters included → invalid
        if (output.length() < reversedList.size()) {
            return "";
        }


        return output.toString();
    }


    // ===== DFS FUNCTION =====
    public boolean dfs(char c) {

        // If already seen
        if (seen.containsKey(c)) {

            // If false → currently visiting → cycle
            return seen.get(c);
        }


        // Mark as visiting (false = still exploring)
        seen.put(c, false);


        // Visit all neighbors
        for (char next : reversedList.get(c)) {

            // If cycle found → return false
            if (!dfs(next)) {
                return false;
            }
        }


        // Mark as fully processed
        seen.put(c, true);


        // Add to result AFTER exploring neighbors
        output.append(c);

        return true;
    }
}
/*
================= 🧾 PROBLEM BRIEF =================

Given words sorted in alien language,
find character order


================= 🧠 CORE INTUITION =================

This is topological sorting problem

→ build graph → run DFS


================= 🔑 KEY IDEA =================

1. Compare adjacent words
2. Find first different character
3. Build directed graph
4. DFS + cycle detection


================= 🧠 EXECUTION FLOW =================

Example:

["wrt", "wrf"]

Compare:
t != f → edge: f → t


DFS:

Visit f → visit t → add t → add f

Result = "tf"


================= ⚠️ IMPORTANT DETAIL =================

seen map:

false → visiting (cycle)
true → visited


================= ⏱ TIME & SPACE =================

Time: O(C)

C = total characters


Space: O(C)


================= 🔥 MEMORY TRICK =================

"Compare adjacent → build graph → DFS → reverse order"


================= 🧠 PATTERN =================

Graph + Topological Sort + Cycle Detection


================================================
*/