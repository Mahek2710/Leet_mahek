class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // Edge case: empty grid
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // These matrices tell:
        // Can water from this cell reach Pacific / Atlantic?
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];


        // ===== STEP 1: START DFS FROM OCEANS =====
        // Instead of going from every cell → ocean (hard)
        // we go from ocean → cells (reverse thinking)


        // Left and Right borders
        for (int i = 0; i < rows; i++) {

            // Pacific (left edge)
            dfs(i, 0, pacificReachable, heights);

            // Atlantic (right edge)
            dfs(i, cols - 1, atlanticReachable, heights);
        }


        // Top and Bottom borders
        for (int j = 0; j < cols; j++) {

            // Pacific (top edge)
            dfs(0, j, pacificReachable, heights);

            // Atlantic (bottom edge)
            dfs(rows - 1, j, atlanticReachable, heights);
        }


        // ===== STEP 2: FIND COMMON CELLS =====
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // If both oceans can reach this cell → valid answer
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }


    // ===== DFS FUNCTION =====
    public void dfs(int row, int col,
                    boolean[][] reachable,
                    int[][] heights) {

        // Mark this cell as reachable from this ocean
        reachable[row][col] = true;


        // 4 directions
        int[][] directions = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };


        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];


            // Boundary check
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }


            // Already visited → skip
            if (reachable[newRow][newCol]) {
                continue;
            }


            // 🔥 CORE CONDITION:
            // We only move to higher or equal height
            // (reverse of water flow)
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, reachable, heights);
            }
        }
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Given a grid of heights,
find all cells from where water can flow to BOTH:

- Pacific Ocean (top + left edges)
- Atlantic Ocean (bottom + right edges)


================= 🧠 CORE INTUITION =================

Normal thinking:
→ water flows DOWN (higher → lower)

But we REVERSE it:

→ start from ocean and go UP (lower → higher)


================= 🔑 KEY IDEA =================

1. Run DFS from Pacific borders → mark reachable
2. Run DFS from Atlantic borders → mark reachable
3. Find intersection of both


================= 🧠 EXECUTION FLOW =================

Instead of:
Cell → Ocean ❌

We do:
Ocean → Cells ✅


Pacific DFS:
Start from top + left edges

Atlantic DFS:
Start from bottom + right edges


Finally:
Cells reachable from BOTH → answer


================= ⚠️ IMPORTANT DETAIL =================

Condition:

heights[new] >= heights[current]

Why?

Because we are reversing water flow direction


================= ⏱ TIME & SPACE =================

Time: O(m × n)

- Each cell visited at most twice


Space: O(m × n)

- recursion + visited arrays


================= 🔥 MEMORY TRICK =================

"Reverse flow → ocean se chalo"

OR

"Find cells reachable FROM both oceans"


================= 🧠 PATTERN =================

Grid + DFS + Reverse Flow

Similar to:
- Surrounded Regions
- Number of Islands
- Multi-source DFS


================================================
*/