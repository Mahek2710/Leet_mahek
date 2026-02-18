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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: both nodes are null → trees match at this branch
        if (p == null && q == null) {
            return true;
        }

        // Case 2: one is null and the other is not → trees differ
        if (p == null || q == null) {
            return false;
        }

        // Case 3: values differ → trees differ
        if (p.val != q.val) {
            return false;
        }

        // Case 4: values match → check left AND right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}

// TC: O(n)
// We compare every node once.

// SC: O(h)
// Recursion stack → h = height of tree
// Worst case (skewed) → O(n)
// Balanced → O(log n)

// 1. If both nodes are null → same.
// 2. If one is null → not same.
// 3. If values differ → not same.
// 4. Recursively check left subtrees.
// 5. Recursively check right subtrees.
// 6. Both must be true → trees are identical.
