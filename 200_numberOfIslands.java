class Solution {

    public int numIslands(char[][] grid) {

        // Total rows and columns of grid
        int rows = grid.length;
        int cols = grid[0].length;

        // This will count number of islands
        int islands = 0;

        // Traverse every cell of the grid
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // If we find land ('1')
                // → this is a NEW island (not visited yet)
                if (grid[i][j] == '1') {

                    islands++;   // count this island

                    // Now destroy (visit) the entire island
                    // so we don't count it again
                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }


    // DFS function to "flood-fill" the island
    public void dfs(int row, int col, char[][] grid) {

        int newRow = grid.length;
        int newCol = grid[0].length;

        // ===== BASE CASE (STOP CONDITIONS) =====

        // 1. Out of bounds → invalid cell
        // 2. Water ('0') → nothing to explore
        if (row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == '0') {
            return; // stop recursion
        }


        // ===== VISIT CURRENT CELL =====

        // Mark this land as visited
        // Trick: convert '1' → '0' (in-place visited marking)
        grid[row][col] = '0';


        // ===== EXPLORE NEIGHBORS =====

        // Move in 4 directions

        // DOWN
        dfs(row + 1, col, grid);

        // UP
        dfs(row - 1, col, grid);

        // RIGHT
        dfs(row, col + 1, grid);

        // LEFT
        dfs(row, col - 1, grid);
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Given a 2D grid of '1's (land) and '0's (water),
count the number of islands.

An island = group of connected '1's
(connected horizontally or vertically).


================= 🧠 EXECUTION FLOW =================

Example:

1 1 0
1 0 0
0 0 1


STEP 1:
Start scanning grid

(0,0) = '1'
→ island++ (islands = 1)
→ call DFS


STEP 2: DFS spreads

(0,0) → mark 0
go to neighbors:

(1,0) → mark 0
(0,1) → mark 0

Whole island becomes:

0 0 0
0 0 0
0 0 1


STEP 3:
Continue scanning

Next '1' at (2,2)
→ island++ (islands = 2)
→ DFS marks it 0


STEP 4:
Grid fully scanned

Final Answer = 2


================= ⏱ TIME & SPACE =================

Time Complexity: O(m × n)

- Every cell is visited once
- DFS ensures no re-visits


Space Complexity: O(m × n) worst case

- Recursion stack (if grid full of land)


================= 🔥 MEMORY TRICK =================

"Find '1' → DFS → convert whole island to '0'"

OR

"Every DFS call = 1 island"


================================================
*/