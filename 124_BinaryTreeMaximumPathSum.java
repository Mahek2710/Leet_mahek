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

    // Global variable to track maximum path sum
    int maxSum = Integer.MIN_VALUE;

    // Helper DFS function that returns max gain from current node
    public int maxGain(TreeNode node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Compute max gain from left subtree (ignore negative paths)
        int leftGain = Math.max(maxGain(node.left), 0);

        // Compute max gain from right subtree (ignore negative paths)
        int rightGain = Math.max(maxGain(node.right), 0);

        // Path sum passing through this node
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global maximum path sum
        maxSum = Math.max(maxSum, priceNewPath);

        // Return max gain if continuing the same path upward
        return node.val + Math.max(leftGain, rightGain);
    }

    // Main function
    public int maxPathSum(TreeNode root) {

        maxGain(root);

        return maxSum;
    }
}


/*
================= LOGIC / STEPS TO REMEMBER =================

Goal:
Find the maximum path sum in a binary tree.

A path:
- Can start and end at ANY node
- Must follow parent-child connections


STEP 1 — Use DFS

At every node calculate the maximum gain
from its left and right subtree.


STEP 2 — Ignore negative paths

If subtree gain is negative,
it will reduce total path sum.

So we use:

Math.max(gain, 0)


STEP 3 — Compute best path through current node

priceNewPath =

node.val + leftGain + rightGain

This represents a path like:

left subtree → node → right subtree


STEP 4 — Update global maximum

maxSum = max(maxSum, priceNewPath)


STEP 5 — Return gain for recursion

When returning to parent we can only choose ONE side.

return:

node.val + max(leftGain, rightGain)


================= COMPLETE EXECUTION FLOW =================

Example Tree

        -10
        /  \
       9   20
          /  \
         15   7


At node 15:
gain = 15

At node 7:
gain = 7

At node 20:
leftGain = 15
rightGain = 7

path = 20 + 15 + 7 = 42
maxSum = 42

return gain = 20 + max(15,7) = 35


At node -10:

leftGain = 9
rightGain = 35

path = -10 + 9 + 35 = 34

maxSum remains 42


Final Answer = 42


================= TIME & SPACE =================

Time Complexity: O(n)

- Each node visited once


Space Complexity: O(h)

- Recursion stack
- h = height of tree


================================================
*/