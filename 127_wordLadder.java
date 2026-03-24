class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // All words have same length → we store it once
        int L = beginWord.length();


        // ===== STEP 1: PREPROCESS WORDS =====
        // Map: generic pattern → list of words
        // Example:
        // "*ot" → ["hot", "dot", "lot"]
        // "h*t" → ["hot", "hit"]
        Map<String, List<String>> allComboDict = new HashMap<>();


        // Loop through each word in dictionary
        for (String word : wordList) {

            // For each position in word
            for (int i = 0; i < L; i++) {

                // Replace character at index i with '*'
                // Example: "hot" → "*ot", "h*t", "ho*"
                String newWord =
                        word.substring(0, i) + "*" + word.substring(i + 1, L);

                // Get existing list for this pattern
                // If not present → create new list
                List<String> transformations =
                        allComboDict.getOrDefault(newWord, new ArrayList<>());

                // Add this word into that pattern group
                transformations.add(word);

                // Put back into map
                allComboDict.put(newWord, transformations);
            }
        }


        // ===== STEP 2: BFS START =====
        // Queue will store:
        // (currentWord, currentLevel)
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        // Start from beginWord, level = 1
        queue.add(new Pair<>(beginWord, 1));


        // Track visited words → to avoid infinite loops
        Map<String, Boolean> visited = new HashMap<>();

        // Mark starting word as visited
        visited.put(beginWord, true);


        // ===== BFS LOOP =====
        while (!queue.isEmpty()) {

            // Take one element from queue
            Pair<String, Integer> node = queue.remove();

            String word = node.getKey();   // current word
            int level = node.getValue();  // steps taken so far


            // Try all possible transformations of current word
            for (int i = 0; i < L; i++) {

                // Create generic pattern for this word
                String newWord =
                        word.substring(0, i) + "*" + word.substring(i + 1, L);


                // Get all words that match this pattern
                // (these are neighbors in graph)
                for (String adjacentWord :
                        allComboDict.getOrDefault(newWord, new ArrayList<>())) {

                    // If we reached target → return answer
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // If this neighbor is not visited yet
                    if (!visited.containsKey(adjacentWord)) {

                        // Mark as visited
                        visited.put(adjacentWord, true);

                        // Add to queue with +1 step
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }

        // If no path found → return 0
        return 0;
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Transform beginWord → endWord

Rules:
- Change ONE letter at a time
- Word must exist in wordList


================= 🧠 CORE INTUITION =================

This is a shortest path problem → BFS


================= 🔑 KEY IDEA =================

Use patterns (*ot, h*t) to find neighbors quickly


================= 🧠 EXECUTION FLOW =================

hit → hot → dot → dog → cog

Answer = 5


================= ⚠️ IMPORTANT DETAIL =================

Pattern replaces 1 letter with '*'

Used to group similar words


================= ⏱ TIME & SPACE =================

Time: O(N × L²)

Space: O(N × L)


================= 🔥 MEMORY TRICK =================

"Replace with * → find neighbors instantly"


================= 🧠 PATTERN =================

Graph + BFS (Shortest Path)


================================================
*/