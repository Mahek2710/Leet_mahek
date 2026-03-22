import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // This value represents an EMPTY room
    // (basically "infinite distance" initially)
    private static final int INF = 2147483647;

    // This helps us move in 4 directions:
    // right → down → left → up
    // We use it like:
    // (row + DIRS[i], col + DIRS[i+1])
    private static final int[] DIRS = {0, 1, 0, -1, 0};


    public void wallsAndGates(int[][] rooms) {

        // If grid is empty → nothing to do
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length;      // number of rows
        int n = rooms[0].length;   // number of columns

        // Queue is used for BFS (like a line)
        // It stores positions: [row, col]
        Queue<int[]> queue = new LinkedList<>();


        // ================= STEP 1 =================
        // Find all gates (cells with value 0)
        // and put them into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If this cell is a gate
                if (rooms[i][j] == 0) {

                    // Add its position into queue
                    // This means BFS will start from here
                    queue.offer(new int[]{i, j});
                }
            }
        }


        // ================= STEP 2 =================
        // Start BFS from all gates at the same time
        while (!queue.isEmpty()) {

            // Take one position from queue
            int[] gate = queue.poll();

            int row = gate[0]; // current row
            int col = gate[1]; // current column


            // Try moving in 4 directions
            for (int i = 0; i < 4; i++) {

                // Calculate new position
                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];


                // Check if:
                // 1. inside grid boundaries
                // 2. this is an EMPTY room (INF)
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    rooms[newRow][newCol] == INF) {

                    // Update distance:
                    // current cell distance + 1
                    rooms[newRow][newCol] = rooms[row][col] + 1;

                    // Add this cell to queue
                    // so it can spread further in next steps
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
Fill each empty room with distance to the NEAREST gate.

If a room cannot reach any gate → it stays INF.


================= 🧠 CORE INTUITION =================

This is a MULTI-SOURCE BFS problem.

Instead of starting from each room,
we start from ALL gates at once.

Why?
→ BFS guarantees shortest distance automatically.


================= 🔑 KEY IDEA =================

1. Push ALL gates (0) into queue
2. Run BFS
3. Expand outward level-by-level
4. Update only INF cells


================= 🧠 EXECUTION FLOW =================

Example:

INF  -1   0   INF
INF INF INF  -1
INF  -1 INF  -1
 0   -1 INF INF


STEP 1:
Queue = [(0,2), (3,0)]  ← all gates


STEP 2 (Distance = 1):
Neighbors of gates become 1

STEP 3 (Distance = 2):
Next layer becomes 2

STEP 4:
Continue BFS until queue empty


Final:
Each cell stores shortest distance to nearest gate


================= ⚠️ IMPORTANT DETAILS =================

1. We ONLY update cells with INF
   → prevents overwriting shorter paths

2. Each cell is visited only once
   → ensures efficiency

3. BFS guarantees shortest path automatically


================= ⏱ TIME & SPACE =================

Time Complexity: O(m × n)

- Every cell processed once


Space Complexity: O(m × n)

- Queue in worst case


================= 🔥 MEMORY TRICK =================

"Gate se BFS chalao"

OR

"All sources → BFS → shortest distance"


================= 🧠 PATTERN =================

Grid + Multi-source BFS

Same pattern as:
- Rotting Oranges
- Walls and Gates
- Shortest Distance Problems


================================================
*/