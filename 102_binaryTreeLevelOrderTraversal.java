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

    // Stores nodes level by level
    List<List<Integer>> ans = new ArrayList<>();

    // DFS helper → keeps track of current level
    public void order(TreeNode node, int level) {

        // If we reached a new level → create a new list
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }

        // Add current node value to its level list
        ans.get(level).add(node.val);

        // Go to left child → next level
        if (node.left != null) {
            order(node.left, level + 1);
        }

        // Go to right child → next level
        if (node.right != null) {
            order(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        // Empty tree → return empty result
        if (root == null) {
            return ans;
        }

        // Start DFS from level 0
        order(root, 0);

        return ans;
    }
}  

// TC: O(n)
// Every node visited once

// SC: O(n)
// Result storage + recursion stack (worst case)

// 1. Maintain a list of lists → one list per level.
//
// 2. Use DFS with a level parameter.
//
// 3. If current level not created → add new list.
//
// 4. Add node value to its level list.
//
// 5. Recurse left with level + 1.
//
// 6. Recurse right with level + 1.

//Tree → DFS → Level tracking → Level Order without queue