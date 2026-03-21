class Solution {

    public int orangesRotting(int[][] grid) {

        // If grid is empty → nothing to process
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length;        // number of rows
        int n = grid[0].length;     // number of columns

        int freshCount = 0;         // how many fresh oranges are left

        // Queue will store all currently rotten oranges
        // IMPORTANT: This is MULTI-SOURCE BFS
        // → all rotten oranges start spreading together
        Queue<int[]> queue = new LinkedList<>();


        // ===== STEP 1: INITIAL SCAN =====
        // We go through the grid once to:
        // 1. Count fresh oranges
        // 2. Add all rotten oranges into queue (starting points of BFS)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    freshCount++; // count fresh orange
                } 
                else if (grid[i][j] == 2) {
                    // Add position of rotten orange
                    queue.offer(new int[]{i, j});
                }
            }
        }


        // If there are no fresh oranges initially → no time needed
        if (freshCount == 0) return 0;


        int minutes = 0; // tracks time taken

        // Directions to move: down, up, right, left
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };


        // ===== STEP 2: BFS =====
        // Each iteration of while loop = 1 minute
        while (!queue.isEmpty()) {

            int size = queue.size();
            // 'size' tells how many oranges are rotten at THIS minute

            // We process all of them together
            for (int i = 0; i < size; i++) {

                int[] rotten = queue.poll(); // take one rotten orange

                int r = rotten[0];
                int c = rotten[1];

                // Try to infect neighbors in 4 directions
                for (int[] dir : directions) {

                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    // Check:
                    // 1. inside grid
                    // 2. it is a fresh orange
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n
                            && grid[newR][newC] == 1) {

                        // Make it rotten
                        grid[newR][newC] = 2;

                        // One fresh orange is now gone
                        freshCount--;

                        // Add this newly rotten orange to queue
                        // → it will spread rot in next minute
                        queue.offer(new int[]{newR, newC});
                    }
                }
            }

            // After processing ALL current rotten oranges
            // → 1 minute has passed
            minutes++;
        }


        // ===== FINAL CHECK =====
        // If all fresh oranges became rotten → success
        // Else → some oranges were unreachable
        return freshCount == 0 ? minutes - 1 : -1;
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Given a grid:
0 → empty cell
1 → fresh orange
2 → rotten orange

Every minute:
→ rotten oranges spread to adjacent fresh ones (4 directions)

Goal:
Return minimum time to rot all oranges
OR -1 if some remain unreachable


================= 🧠 CORE INTUITION =================

This is a MULTI-SOURCE BFS problem.

Instead of starting from one node,
we start BFS from ALL rotten oranges at once.

Each BFS level = 1 minute


================= 🔑 KEY IDEA =================

1. Put all rotten oranges into queue
2. Spread rot level by level
3. Track fresh oranges
4. Count minutes


================= 🧠 EXECUTION FLOW =================

Example:

2 1 1
1 1 0
0 1 1


STEP 1:
Initial scan

Queue = [(0,0)]
freshCount = 6


STEP 2 (Minute 1):
(0,0) spreads → (0,1), (1,0)

Queue = [(0,1),(1,0)]
freshCount = 4


STEP 3 (Minute 2):
New rotten spread further

Queue grows
freshCount decreases


STEP 4:
Eventually freshCount = 0

Return minutes


================= ⚠️ IMPORTANT DETAIL =================

Why return (minutes - 1)?

Because:
Last increment happens AFTER final spread
(even when no new oranges rot)


================= ⏱ TIME & SPACE =================

Time Complexity: O(m × n)

- Each cell visited once


Space Complexity: O(m × n)

- Queue stores cells (worst case)


================= 🔥 MEMORY TRICK =================

"Multi-source BFS → all rotten spread together"

OR

"Each BFS level = 1 minute"


================= 🧠 PATTERN =================

Grid + BFS + Level Order Traversal

Used in:
- Rotting Oranges
- Walls and Gates
- Shortest Path in Grid


================================================
*/

