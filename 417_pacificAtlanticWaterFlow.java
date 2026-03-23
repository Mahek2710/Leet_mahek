class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // Edge case: empty grid
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // These matrices tell:
        // whether a cell can reach Pacific / Atlantic ocean
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];


        // ================= STEP 1 =================
        // Start DFS from ocean borders (reverse thinking)

        // Left (Pacific) and Right (Atlantic) borders
        for (int i = 0; i < rows; i++) {

            // Pacific ocean → left edge
            dfs(i, 0, pacificReachable, heights);

            // Atlantic ocean → right edge
            dfs(i, cols - 1, atlanticReachable, heights);
        }

        // Top (Pacific) and Bottom (Atlantic) borders
        for (int j = 0; j < cols; j++) {

            // Pacific ocean → top edge
            dfs(0, j, pacificReachable, heights);

            // Atlantic ocean → bottom edge
            dfs(rows - 1, j, atlanticReachable, heights);
        }


        // ================= STEP 2 =================
        // Find cells reachable from BOTH oceans
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }


    // ================= DFS =================
    public void dfs(int row, int col,
                    boolean[][] reachable,
                    int[][] heights) {

        // Mark current cell as reachable from this ocean
        reachable[row][col] = true;

        // 4 directions (right, down, up, left)
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

            // 🔥 CORE LOGIC:
            // Skip lower heights
            // → only move to equal or higher heights
            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            // Continue DFS
            dfs(newRow, newCol, reachable, heights);
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

Condition used:

if (heights[new] < heights[current]) continue;

Meaning:
→ skip lower heights

So effectively:
→ we ONLY move to equal or higher heights

This matches reverse water flow logic


================= ⏱ TIME & SPACE =================

Time: O(m × n)

- Each cell visited at most twice


Space: O(m × n)

- recursion stack + visited arrays


================= 🔥 MEMORY TRICK =================

"Skip lower → go only higher"

OR

"Ocean se chalo, water nahi"


================= 🧠 PATTERN =================

Grid + DFS + Reverse Flow

Same pattern as:
- Surrounded Regions
- Number of Islands
- Multi-source traversal


================================================
*/