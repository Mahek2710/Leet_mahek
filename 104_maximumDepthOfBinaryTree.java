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

    public int maxDepth(TreeNode root) {

        // Base case → empty tree has depth 0
        if (root == null) {
            return 0;
        }

        // Recursively find depth of left subtree
        int leftMax = maxDepth(root.left);

        // Recursively find depth of right subtree
        int rightMax = maxDepth(root.right);

        // Current depth = 1 (current node)
        // + maximum of left and right subtree depths
        return Math.max(leftMax, rightMax) + 1;
    }
}

// TC: O(n)
// We visit every node exactly once.

// SC: O(h)
// h = height of tree (recursion stack)
// Worst case (skewed tree) → O(n)
// Balanced tree → O(log n)


// 1. If node is null → depth = 0.
//
// 2. Recursively compute depth of left subtree.
//
// 3. Recursively compute depth of right subtree.
//
// 4. Take the maximum of both depths.
//
// 5. Add 1 for the current node.
//
// 6. Return the result.
