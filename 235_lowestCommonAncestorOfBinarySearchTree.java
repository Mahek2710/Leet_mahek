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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Store current root value
        int parentVal = root.val;

        // Store p and q values
        int pVal = p.val;
        int qVal = q.val;

        // If both p and q are greater than root,
        // LCA must be in right subtree.
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both p and q are smaller than root,
        // LCA must be in left subtree.
        if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Otherwise:
        // Either we split here OR one node equals root.
        // So current root is the LCA.
        return root;
    }
}


/* ===== COMPLETE EXECUTION FLOW =====

1. Start at the root node.

2. Compare p and q values with root value.

3. Case 1:
   If both p and q > root
   → Both nodes lie in right subtree.
   → Move to root.right.

4. Case 2:
   If both p and q < root
   → Both nodes lie in left subtree.
   → Move to root.left.

5. Case 3:
   If one is smaller and one is larger
   OR one equals root
   → This is the split point.
   → Current root is the Lowest Common Ancestor.

6. Return the LCA node.


===== Key Insight =====
Because it is a BST:
- Left subtree values < root
- Right subtree values > root

We use this property to eliminate half of the tree at each step.

Time Complexity: O(h)
h = height of tree

Space Complexity: O(h)
Due to recursion stack
*/