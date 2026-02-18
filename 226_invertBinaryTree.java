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

    public TreeNode invertTree(TreeNode root) {

        // Base case → empty subtree
        if (root == null) {
            return null;
        }

        // Recursively invert right subtree
        TreeNode right = invertTree(root.right);

        // Recursively invert left subtree
        TreeNode left = invertTree(root.left);

        // Swap left and right children
        root.left = right;
        root.right = left;

        // Return current root after swap
        return root;
    }
}

// TC: O(n)
// We visit every node once.

// SC: O(h)
// Recursion stack (h = height of tree)
// Worst case → O(n), Balanced → O(log n)

// 1. If node is null → return null.
//
// 2. Recursively invert the right subtree.
//
// 3. Recursively invert the left subtree.
//
// 4. Swap left and right children.
//
// 5. Return the current node.
