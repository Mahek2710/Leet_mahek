class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        // Edge case
        if (grid == null || grid.length == 0) return 0;

        int maxArea = 0; // stores maximum island area found

        // Traverse entire grid
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                // If land found → start DFS to calculate area
                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j); // get area of this island

                    // Update max area
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }


    // DFS returns area of island starting from (i, j)
    private int dfs(int[][] grid, int i, int j) {

        // ===== BASE CASE =====
        // 1. Out of bounds
        // 2. Water cell
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        // ===== VISIT CURRENT CELL =====

        // Mark visited (convert land → water)
        grid[i][j] = 0;

        // Current cell contributes area = 1
        int area = 1;

        // ===== EXPLORE ALL DIRECTIONS =====

        // Add area from all connected neighbors
        area += dfs(grid, i + 1, j); // down
        area += dfs(grid, i - 1, j); // up
        area += dfs(grid, i, j + 1); // right
        area += dfs(grid, i, j - 1); // left

        return area;
    }
}


/*
================= 🧾 PROBLEM BRIEF =================

Given a grid of 0s (water) and 1s (land),
find the MAXIMUM area of an island.

Island = connected 1s (4-directional).


================= 🧠 EXECUTION FLOW =================

Example:

1 1 0
1 0 0
0 0 1


STEP 1:
(0,0) = 1 → start DFS

DFS expands:
(0,0) → (1,0) → (0,1)

Total cells visited = 3
→ area = 3

maxArea = 3


STEP 2:
Continue scanning

(2,2) = 1 → DFS

area = 1

maxArea = max(3,1) = 3


FINAL ANSWER = 3


================= 🔑 KEY DIFFERENCE =================

In "Number of Islands":
→ count islands

In this problem:
→ calculate SIZE of each island

class Solution {

    public int solve(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int answer = 0; // can be count OR maxArea

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    // 🔥 CHANGE THIS LINE ONLY
                    answer = Math.max(answer, area);   // for MAX AREA
                    // answer++;                      // for COUNT ISLANDS
                }
            }
        }

        return answer;
    }


    // DFS returns size of island
    private int dfs(int[][] grid, int i, int j) {

        // Base case
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // Mark visited
        grid[i][j] = 0;

        // Count current cell
        int area = 1;

        // Explore neighbors
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i, j - 1);

        return area;
    }
}

// For Number of Islands
answer++;

// For Max Area of Island
answer = Math.max(answer, area);

SAME DFS does 2 jobs:
1. Marks island (visited)
2. Returns size of island

================= ⏱ TIME & SPACE =================

Time Complexity: O(m × n)

- Every cell visited once


Space Complexity: O(m × n) worst case

- Recursion stack (if full grid is land)


================= 🔥 MEMORY TRICK =================

"DFS returns area → keep adding → take max"

OR

"Instead of counting islands → measure island size"


================================================
*/