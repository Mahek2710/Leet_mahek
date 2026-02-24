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

    // This variable stores the maximum diameter found so far.
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        // Start DFS to calculate height of each node.
        // During height calculation, we update maxDiameter.
        getHeight(root);

        // Return the maximum diameter found.
        return maxDiameter;
    }

    private int getHeight(TreeNode node) {

        // Base Case:
        // If node is null, height is 0.
        if (node == null) {
            return 0;
        }

        // Recursively calculate height of left subtree.
        int leftHeight = getHeight(node.left);

        // Recursively calculate height of right subtree.
        int rightHeight = getHeight(node.right);

        // At current node:
        // Diameter passing through this node =
        // leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of current node:
        // 1 (current node) + max of left and right heights.
        return 1 + Math.max(leftHeight, rightHeight);
    }
}


// ===== Execution Flow Summary =====
//
// 1. Start DFS traversal from root.
// 2. For each node, compute left subtree height.
// 3. Compute right subtree height.
// 4. Diameter through current node = leftHeight + rightHeight.
// 5. Update global maxDiameter if this is larger.
// 6. Return height of current node to parent.
// 7. After full traversal, return maxDiameter.
//
// Time Complexity: O(n)
// Each node is visited exactly once.
//
// Space Complexity: O(h)
// h = height of tree (recursive stack space).



/* ===== COMPLETE EXECUTION FLOW (How Recursion Actually Progresses) =====

1. diameterOfBinaryTree(root) is called.

2. getHeight(root) starts recursive DFS.

3. Recursion goes ALL THE WAY DOWN to the leftmost leaf
   before doing any diameter calculation.

4. When a null node is reached:
   → return 0 (base case).

5. Heights start returning upward:
   - Leaf node returns height = 1.
   - Parent receives leftHeight and rightHeight.

6. At EACH node:
   - Calculate leftHeight.
   - Calculate rightHeight.
   - Compute diameter through that node:
         leftHeight + rightHeight.
   - Update maxDiameter if larger.

7. Height of current node is returned upward:
         1 + max(leftHeight, rightHeight).

8. This process continues bottom-up
   until we reach back to the root.

9. By the time recursion finishes:
   maxDiameter contains the largest
   leftHeight + rightHeight found anywhere in the tree.

10. Return maxDiameter as final answer.


===== Key Insight =====
- Height is returned upward.
- Diameter is calculated at EVERY node.
- We do not calculate diameter separately.
- It is computed while calculating height.