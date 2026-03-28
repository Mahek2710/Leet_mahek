class Solution {

    public int swimInWater(int[][] grid) {

        int n = grid.length; // Grid is n x n

        // --------------------------------------------------
        // BINARY SEARCH RANGE
        // --------------------------------------------------
        // We are searching for the minimum time 't' such that
        // we can go from (0,0) to (n-1,n-1)

        // Minimum possible time:
        // We must at least wait until the starting cell is accessible
        int left = grid[0][0];

        // Maximum possible time:
        // Grid contains values from 0 to (n*n - 1)
        // So worst case: we wait until the highest cell is submerged
        int right = n * n - 1;


        // --------------------------------------------------
        // BINARY SEARCH ON TIME
        // --------------------------------------------------
        while (left < right) {

            // Try the middle time
            int mid = left + (right - left) / 2;

            // Check: Can we reach destination if water level = mid ?
            if (canSwim(grid, mid)) {

                // YES → Try to find a smaller valid time
                right = mid;

            } else {

                // NO → We need more time (increase water level)
                left = mid + 1;
            }
        }

        // When loop ends, left == right
        // This is the minimum time required
        return left;
    }


    // --------------------------------------------------
    // CHECK FUNCTION
    // --------------------------------------------------
    // Returns true if we can reach bottom-right cell
    // when water level = t
    private boolean canSwim(int[][] grid, int t) {

        int n = grid.length;

        // Track visited cells to avoid infinite loops
        boolean[][] visited = new boolean[n][n];

        // Start DFS from top-left cell (0,0)
        return dfs(grid, visited, 0, 0, t);
    }


    // --------------------------------------------------
    // DFS FUNCTION
    // --------------------------------------------------
    // Try to reach (n-1, n-1) from (i, j)
    private boolean dfs(int[][] grid, boolean[][] visited,
                        int i, int j, int t) {

        int n = grid.length;


        // --------------------------------------------------
        // BASE CASES (STOP CONDITIONS)
        // --------------------------------------------------

        // 1. Out of grid boundaries
        // 2. Already visited this cell
        // 3. Cell is too high (not submerged yet)
        if (i < 0 || i >= n || j < 0 || j >= n ||
            visited[i][j] || grid[i][j] > t) {
            return false;
        }


        // --------------------------------------------------
        // SUCCESS CONDITION
        // --------------------------------------------------

        // If we reached bottom-right cell → path exists
        if (i == n - 1 && j == n - 1) {
            return true;
        }


        // --------------------------------------------------
        // MARK CURRENT CELL AS VISITED
        // --------------------------------------------------
        visited[i][j] = true;


        // --------------------------------------------------
        // EXPLORE ALL 4 DIRECTIONS
        // --------------------------------------------------
        // If ANY direction reaches destination → return true

        return dfs(grid, visited, i + 1, j, t) ||  // Down
               dfs(grid, visited, i - 1, j, t) ||  // Up
               dfs(grid, visited, i, j + 1, t) ||  // Right
               dfs(grid, visited, i, j - 1, t);    // Left
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

You are given an n x n grid where:
- Each cell has a unique height (0 → n² - 1)
- Water level rises over time (t = 0,1,2,...)

At time = t:
- You can ONLY step on cells with value <= t

Goal:
👉 Find the MINIMUM time required to go from
   (0,0) → (n-1,n-1)


--------------------------------------------------


================= 🧠 CORE INTUITION =================

This is NOT a shortest path in steps problem.

Instead, it's:
👉 "What is the minimum water level needed so that a path exists?"

So we:
✔ Guess a time (t)
✔ Check if path exists under that condition

This screams:
👉 Binary Search on Answer


--------------------------------------------------


================= 🔑 KEY IDEA =================

We don't directly find the path.

Instead:

1. Pick a candidate time = mid
2. Treat all cells with value > mid as BLOCKED
3. Check:
   "Can I reach destination using only allowed cells?"

If YES → mid is valid (maybe we can do better)
If NO  → mid is too small (need more water)


--------------------------------------------------


================= 🧠 EXECUTION FLOW =================

Binary Search Range:

left  = grid[0][0]     // Must at least stand on start
right = n*n - 1        // Max possible height in grid


While (left < right):

    mid = (left + right) / 2

    If path exists at time = mid:
        → Try smaller time (right = mid)

    Else:
        → Increase time (left = mid + 1)


Finally:
👉 left == minimum valid time


--------------------------------------------------


================= 🔍 HOW DFS CHECK WORKS =================

We simulate:

"Can I move from start to end if water level = t?"

Rules:
- You can move up/down/left/right
- You can ONLY go to cells where:
      grid[i][j] <= t

DFS does:
1. Start from (0,0)
2. Explore all valid neighbors
3. Stop if:
   - Out of bounds
   - Already visited
   - Cell value > t (not submerged yet)
4. If we reach (n-1,n-1) → SUCCESS


--------------------------------------------------


================= ⚠️ IMPORTANT DETAIL =================

Condition:

    grid[i][j] <= t

Meaning:
- Water must be at least as high as the cell
- Otherwise, that cell is "blocked"

Think:
👉 Water gradually "unlocks" cells


--------------------------------------------------


================= 🧠 VISUAL THINKING =================

Imagine grid as heights:

At time t:
- All cells ≤ t become "walkable"
- Others are walls

So problem becomes:
👉 "Is there a path in this dynamically unlocked grid?"


--------------------------------------------------


================= ⏱ TIME & SPACE =================

Binary Search:
    O(log (n²)) ≈ O(log n)

DFS each time:
    O(n²)

Total Time:
    O(n² log n)

Space:
    O(n²) for visited array


--------------------------------------------------


================= 🔥 MEMORY TRICK =================

When you see:

"Minimum X such that condition is possible"

Think:
👉 Binary Search on Answer

When you see:

"Can I reach somewhere under constraints?"

Think:
👉 DFS / BFS


--------------------------------------------------


================= 🧠 PATTERN =================

This problem combines:

1. Binary Search on Answer
2. Graph Traversal (DFS/BFS)

Very common combo in interviews.


--------------------------------------------------


================= 🧩 DEEP INTUITION (IMPORTANT) =================

We are NOT minimizing:
- Steps
- Distance

We ARE minimizing:
👉 Maximum height encountered along the path

Equivalent thinking:
👉 "Find a path where the highest cell value is as small as possible"

Binary search helps us test that efficiently.


--------------------------------------------------


================= 🚀 ALTERNATIVE (ADVANCED) =================

Same problem can be solved using:

👉 Dijkstra / Min Heap

Where:
- Cost = max height seen so far

This is often faster in practice and preferred in interviews.


================================================
*/