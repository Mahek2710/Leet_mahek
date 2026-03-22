import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Value representing empty room (infinity)
    private static final int INF = 2147483647;

    // Direction array for 4 directions:
    // right, down, left, up
    private static final int[] DIRS = {0, 1, 0, -1, 0};


    public void wallsAndGates(int[][] rooms) {

        // Edge case
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;

        // Queue for BFS (stores positions)
        Queue<int[]> queue = new LinkedList<>();


        // ===== STEP 1: ADD ALL GATES (MULTI-SOURCE BFS) =====
        // Gates = cells with value 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (rooms[i][j] == 0) {
                    // Add gate position to queue
                    queue.offer(new int[]{i, j});
                }
            }
        }


        // ===== STEP 2: BFS FROM ALL GATES =====
        while (!queue.isEmpty()) {

            int[] gate = queue.poll();

            int row = gate[0];
            int col = gate[1];

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {

                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];


                // Check:
                // 1. Inside grid
                // 2. Only process EMPTY rooms (INF)
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    rooms[newRow][newCol] == INF) {

                    // Update distance:
                    // distance = current cell + 1
                    rooms[newRow][newCol] = rooms[row][col] + 1;

                    // Add this cell to queue for next BFS level
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Grid contains:
- 0 → gate
- -1 → wall
- INF → empty room

Goal:
Fill each empty room with distance to its nearest gate.

If a gate is unreachable → it remains INF.


================= 🧠 CORE INTUITION =================

This is a MULTI-SOURCE BFS problem.

Instead of starting from each room,
we start from ALL gates at once.

Why?
→ BFS guarantees shortest distance.


================= 🔑 KEY IDEA =================

1. Add all gates (0) into queue
2. Start BFS from all gates together
3. Spread distance level by level
4. Update only INF cells


================= 🧠 EXECUTION FLOW =================

Example:

INF  -1   0   INF
INF INF INF  -1
INF  -1 INF  -1
 0   -1 INF INF


STEP 1:
Queue = [(0,2), (3,0)]   ← all gates


STEP 2:
Minute 1 → fill neighbors with 1

STEP 3:
Minute 2 → fill next neighbors with 2

STEP 4:
Continue BFS until queue empty


Final grid will have shortest distance to nearest gate


================= ⚠️ IMPORTANT DETAIL =================

We ONLY update cells with INF

→ ensures:
- we don't overwrite shorter distances
- each cell is updated only once


================= ⏱ TIME & SPACE =================

Time Complexity: O(m × n)

- Each cell is visited once


Space Complexity: O(m × n)

- Queue in worst case


================= 🔥 MEMORY TRICK =================

"Start from gates, not rooms"

OR

"Multi-source BFS gives shortest path"


================= 🧠 PATTERN =================

Grid + Multi-source BFS

Same pattern as:
- Rotting Oranges
- Walls and Gates
- Shortest Path in Grid


================================================
*/