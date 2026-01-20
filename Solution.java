public class Solution {
    public List<String> generateParenthesis(int n) {

        // List to store all valid combinations
        List<String> ans = new ArrayList<>();

        // Start backtracking with an empty string
        backtrack(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans,
                           StringBuilder cur,
                           int open,
                           int close,
                           int max) {

        // If the current string length is 2 * n,
        // we have used all parentheses
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        // Add '(' if we still have opening brackets left
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1); // backtrack
        }

        // Add ')' only if it won’t make the string invalid
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1); // backtrack
        }
    }
}

// TC: O(4^n / √n)
// Number of valid parentheses combinations (Catalan numbers).

// SC: O(n)
// Maximum depth of recursion + StringBuilder space.


// 1. Use backtracking to build the string character by character.
// 2. Add '(' only if we haven’t used all opening brackets.
// 3. Add ')' only if it won’t exceed the number of '(' used.
// 4. When the string length becomes 2 * n, store it.
// 5. Backtrack by removing the last added character.
// 6. Continue until all valid combinations are generated.
 {
    
}
