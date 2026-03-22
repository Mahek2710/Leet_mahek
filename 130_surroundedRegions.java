class Solution {

    public void solve(char[][] board) {

        // Edge case
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;


        // ===== STEP 1: MARK SAFE REGIONS =====
        // We ONLY start DFS from boundary 'O's
        // because boundary 'O's can NEVER be surrounded
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If cell is on boundary AND is 'O'
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && board[i][j] == 'O') {

                    // Mark all connected 'O's as safe ('T')
                    dfs(board, i, j);
                }
            }
        }


        // ===== STEP 2: CONVERT REMAINING =====
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // These are surrounded → convert to 'X'
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // These were safe → revert back
                else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    // DFS to mark safe cells
    private void dfs(char[][] board, int i, int j) {

        // Stop if:
        // 1. Out of bounds
        // 2. Not an 'O'
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        // Mark this cell as safe
        board[i][j] = 'T';

        // Explore all 4 directions
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
/*
================= 🧾 PROBLEM BRIEF =================

Given a board of 'X' and 'O':

Flip all 'O' regions that are COMPLETELY surrounded by 'X'.

Reverse thinking:
Don't find surrounded → find SAFE first


================= 🧠 CORE INTUITION =================

We DON'T find surrounded regions directly ❌

Instead:
→ Find NON-surrounded regions (safe ones) ✅


================= 🔑 KEY IDEA =================

1. All boundary 'O's are SAFE
2. DFS from boundary → mark connected 'O's as 'T'
3. Remaining 'O's = surrounded → convert to 'X'
4. Convert 'T' back to 'O'


================= 🧠 EXECUTION FLOW =================

Example:

X X X X
X O O X
X X O X
X O X X


STEP 1:
Boundary 'O' → (3,1)

DFS marks:
(3,1) → 'T'


STEP 2:
Board becomes:

X X X X
X O O X
X X O X
X T X X


STEP 3:
Convert:

'O' → 'X' (surrounded)
'T' → 'O' (safe)


Final:

X X X X
X X X X
X X X X
X O X X


================= ⚠️ IMPORTANT DETAIL =================

Why mark 'T'?

→ To remember safe cells
→ So we don't lose them while converting


================= ⏱ TIME & SPACE =================

Time Complexity: O(m × n)

- Each cell visited once


Space Complexity: O(m × n)

- Recursion stack


================= 🔥 MEMORY TRICK =================

"Boundary se DFS → safe mark karo"

OR

"Don't find surrounded, find SAFE first"


================= 🧠 PATTERN =================

Grid + DFS + Boundary Traversal

Same idea as:
- Number of Islands
- Flood Fill
- Capture Regions


================================================
*/