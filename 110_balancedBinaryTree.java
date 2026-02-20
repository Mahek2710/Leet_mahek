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

    public boolean isBalanced(TreeNode root) {

        // Empty tree is balanced
        if (root == null) {
            return true;
        }

        // Get height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // If height difference > 1 → not balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check left and right subtrees
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {

        // Height of empty subtree = 0
        if (node == null) {
            return 0;
        }

        // Height = 1 + max(left subtree height, right subtree height)
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// TC: O(n²)
// For each node we calculate height → height takes O(n)
// Done for every node → O(n²) worst case

// SC: O(h)
// Recursion stack (h = height of tree)
// Worst case → O(n), balanced → O(log n)

// 1. For every node, compute height of left subtree.
// 2. Compute height of right subtree.
// 3. Check if |leftHeight - rightHeight| ≤ 1.
// 4. Recursively ensure left subtree is balanced.
// 5. Recursively ensure right subtree is balanced.
// 6. All conditions true → tree is balanced.