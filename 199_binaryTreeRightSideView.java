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

    public List<Integer> rightSideView(TreeNode root) {

        // Stores the visible nodes from the right side
        List<Integer> result = new ArrayList<>();

        // Edge case → empty tree
        if (root == null) {
            return result;
        }

        // Standard BFS queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                // The LAST node we process in this level
                // is the one visible from the right side
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Add left child for next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add right child for next level
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }
}
// TC: O(n)
// Every node visited once

// SC: O(n)
// Queue + result list

// 1. Use BFS (queue) to traverse level by level.
//
// 2. For each level, get the number of nodes (levelSize).
//
// 3. Process nodes in that level.
//
// 4. When processing the LAST node of the level,
//    add its value to result.
//
// 5. Continue for all levels.