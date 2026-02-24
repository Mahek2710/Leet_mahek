/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public boolean isSame(TreeNode s, TreeNode t) {

        // If both nodes are null → trees are identical
        if (s == null && t == null) {
            return true;
        }

        // If one is null → not identical
        if (s == null || t == null) {
            return false;   // (only fixed return type, logic same)
        }

        // If values don't match → not identical
        if (s.val != t.val) {
            return false;
        }

        // Recursively check left and right
        return isSame(s.left, t.left) &&
               isSame(s.right, t.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If root becomes null → subtree not found
        if (root == null) {
            return false;
        }

        // If trees match at current node
        if (isSame(root, subRoot)) {
            return true;
        }

        // Check left OR right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);   // (only fixed brackets & typo)
    }
}


// TC: O(n * m)
// For every node in root, we may compare full subRoot.

// SC: O(h)
// Recursive stack height of tree.

// 1. Traverse every node in root.
// 2. At each node, check if trees are identical using isSame().
// 3. If identical → return true.
// 4. Otherwise, search in left and right.
// 5. If no match found → return false.

// ===== Execution Flow Explanation =====

// 1. isSubtree(root, subRoot) is called.

// 2. If root becomes null:
//    → We have reached the end of the main tree
//    → Subtree was not found
//    → Return false

// 3. If root is not null:
//    → Call isSame(root, subRoot)
//    → This checks whether the subtree starting
//      from the current root node matches subRoot completely.


// ===== Inside isSame(s, t) =====

// 4. If both s and t are null:
//    → Both trees ended together
//    → Structure matches
//    → Return true

// 5. If one is null and the other is not:
//    → Structure mismatch
//    → Return false

// 6. If values of s and t are different:
//    → Nodes don’t match
//    → Return false

// 7. If values match:
//    → Recursively check left children
//    → Recursively check right children
//    → Return true only if BOTH left and right match


// ===== Back to isSubtree =====

// 8. If isSame(root, subRoot) returns true:
//    → We found identical subtree
//    → Return true immediately

// 9. If not identical at current node:
//    → Recursively search in left subtree
//    → Recursively search in right subtree

// 10. If either left OR right returns true:
//     → Subtree found
//     → Return true

// 11. If entire tree is searched and no match found:
//     → Return false


// Overall Idea:
// - Traverse every node in root.
// - At each node, try to match the full subRoot.
// - Stop immediately when match is found.
// - Otherwise continue searching until tree ends.