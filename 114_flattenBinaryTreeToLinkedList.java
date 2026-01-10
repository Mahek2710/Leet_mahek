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

    // Helper function that flattens the tree
    // and returns the tail node of the flattened subtree
    public TreeNode flattenTree(TreeNode node) {

        // Base case: empty subtree
        if (node == null) {
            return null;
        }

        // Base case: leaf node is already flat
        if (node.left == null && node.right == null) {
            return node;
        }

        // Recursively flatten left and right subtrees
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        // If there is a left subtree,
        // attach it between the current node and the right subtree
        if (leftTail != null) {

            // Connect left subtree's tail to original right subtree
            leftTail.right = node.right;

            // Move left subtree to the right
            node.right = node.left;

            // Set left child to null (linked-list requirement)
            node.left = null;
        }

        // Return the tail of the flattened subtree
        return rightTail == null ? leftTail : rightTail;
    }

    // Main function required by the problem
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
}

// TC: O(n)
// Each node is visited once.

// SC: O(h)
// h = height of the tree (recursive call stack).

// 1. Recursively flatten the left subtree.
// 2. Recursively flatten the right subtree.
// 3. If a left subtree exists:
//    - Attach the original right subtree to the end of the left subtree.
//    - Move the left subtree to the right side.
//    - Set left pointer to null.
// 4. Return the tail of the flattened subtree.
