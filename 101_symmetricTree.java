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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean isSymmetric(TreeNode root) {

        // Empty tree is symmetric
        if (root == null) {
            return true;
        }

        // Check if left and right subtrees are mirror images
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // Case 1: both null → mirror
        if (left == null && right == null) {
            return true;
        }

        // Case 2: one null → not mirror
        if (left == null || right == null) {
            return false;
        }

        // Case 3: values must match AND children must be mirror
        return (left.val == right.val)
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}

// TC: O(n)
// Every node is visited once.

// SC: O(h)
// Recursion stack height = tree height
// Worst case → O(n)
// Balanced → O(log n)

// 1. A tree is symmetric if its left and right subtrees are mirror images.
//
// 2. Mirror condition:
//    left.val == right.val
//
// 3. Outer children must match:
//    left.left ↔ right.right
//
// 4. Inner children must match:
//    left.right ↔ right.left
//
// 5. Repeat recursively for all nodes.
