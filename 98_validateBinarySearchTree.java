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

    // This variable stores the previous node value
    // during inorder traversal.
    public Integer prev;

    public boolean isValidBST(TreeNode root) {

        // Initialize prev as null before traversal.
        prev = null;

        // Perform inorder traversal.
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {

        // Base Case:
        // If node is null, it's valid by default.
        if (root == null) {
            return true;
        }

        // 1. Traverse left subtree first.
        // If left subtree is invalid, stop immediately.
        if (!inOrder(root.left)) {
            return false;
        }

        // 2. Process current node.
        // In a valid BST, inorder traversal
        // must produce strictly increasing values.
        if (prev != null && root.val <= prev) {
            return false;
        }

        // 3. Update prev to current node value.
        prev = root.val;

        // 4. Traverse right subtree.
        return inOrder(root.right);
    }
}


/* ===== COMPLETE EXECUTION FLOW =====

1. isValidBST(root) is called.
2. prev is initialized to null.
3. Inorder traversal begins.

4. Recursion goes all the way to the leftmost node.
5. When a null node is reached → return true.

6. While returning upward:
   - Compare current node value with prev.
   - If current value <= prev → BST condition fails.
   - Otherwise update prev = current value.

7. Continue traversal to the right subtree.

8. If at any point BST rule is violated,
   return false immediately.

9. If full traversal completes without violation,
   return true.


===== Key Insight =====
- Inorder traversal of a BST produces
  strictly increasing values.
- We simply check whether this property holds.

Time Complexity: O(n)
Each node is visited once.

Space Complexity: O(h)
h = height of tree (recursion stack).
*/