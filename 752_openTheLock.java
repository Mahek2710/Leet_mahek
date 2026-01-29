class Solution {
    public int openLock(String[] deadends, String target) {

        // Store all deadend combinations in a set for O(1) lookup
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        // If starting position is blocked, we cannot move at all
        if (dead.contains("0000")) return -1;

        // If target is already the starting position
        if ("0000".equals(target)) return 0;

        // Queue for BFS (level-by-level traversal)
        Queue<String> q = new ArrayDeque<>();

        // Set to track visited combinations to avoid cycles
        Set<String> seen = new HashSet<>();

        // Start BFS from "0000"
        q.offer("0000");
        seen.add("0000");

        // Number of moves made so far
        int steps = 0;

        // Standard BFS loop
        while (!q.isEmpty()) {

            // Number of nodes at current BFS level
            int size = q.size();

            // Process all nodes at this level (same number of moves)
            for (int s = 0; s < size; s++) {

                // Get current lock state
                String cur = q.poll();

                // Skip if this state is a deadend
                if (dead.contains(cur)) continue;

                // If target is reached, steps is the minimum moves
                if (cur.equals(target)) return steps;

                // Convert string to char array to modify digits
                char[] cs = cur.toCharArray();

                // Try rotating each of the 4 wheels
                for (int i = 0; i < 4; i++) {

                    // Save original digit
                    char original = cs[i];
                    int digit = original - '0';

                    // Rotate wheel forward (+1)
                    cs[i] = (char) ('0' + (digit + 1) % 10);
                    String up = new String(cs);

                    // Add to queue if not dead and not visited
                    if (!dead.contains(up) && seen.add(up)) {
                        q.offer(up);
                    }

                    // Rotate wheel backward (-1)
                    cs[i] = (char) ('0' + (digit + 9) % 10);
                    String down = new String(cs);

                    // Add to queue if not dead and not visited
                    if (!dead.contains(down) && seen.add(down)) {
                        q.offer(down);
                    }

                    // Restore original digit before next wheel
                    cs[i] = original;
                }
            }

            // Finished one full BFS level → one move
            steps++;
        }

        // Target cannot be reached
        return -1;
    }
}



// TC: O(10^4)
// There are at most 10,000 possible lock combinations.

// SC: O(10^4)
// Queue + visited set may store all combinations.


// 1. Treat each lock combination as a node in a graph.
// 2. Start BFS from "0000".
// 3. Each move generates up to 8 neighbors (4 wheels × up/down).
// 4. Skip deadends and already visited states.
// 5. BFS guarantees the first time we reach target is minimum steps.
// 6. If BFS finishes without reaching target, return -1.



/*
CODE WORKFLOW:

1. Treat each 4-digit lock combination as a node in a graph.
2. Use Breadth-First Search (BFS) to find the shortest path
   from "0000" to the target combination.

3. Start BFS from "0000":
   - Add "0000" to the queue.
   - Mark it as visited.

4. For each BFS level (represents one wheel move):
   - Process all states currently in the queue.
   - For each state:
     a) Skip it if it is a deadend.
     b) If it matches the target, return the current step count.

5. Generate next states by rotating each of the 4 wheels:
   - Rotate wheel forward (+1).
   - Rotate wheel backward (-1).
   - This produces up to 8 neighboring states.

6. For each generated state:
   - If it is not a deadend and not visited before,
     add it to the queue and mark it as visited.

7. After processing all states at the current level:
   - Increment step count (one move completed).

8. If BFS ends without reaching the target:
   - Return -1 (target cannot be unlocked).
*/

