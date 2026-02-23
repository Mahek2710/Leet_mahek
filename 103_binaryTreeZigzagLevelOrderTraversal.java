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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Edge case → empty tree
        if (root == null) {
            return new ArrayList<>();
        }

        // Final result
        List<List<Integer>> results = new ArrayList<>();

        // Queue for BFS
        LinkedList<TreeNode> node_queue = new LinkedList<>();

        // Add root and a null marker (marks end of level)
        node_queue.addLast(root);
        node_queue.addLast(null);

        // Stores values of current level
        LinkedList<Integer> level_list = new LinkedList<>();

        // Direction flag → true = left → right, false = right → left
        boolean is_order_left = true;

        while (node_queue.size() > 0) {

            TreeNode curr_node = node_queue.pollFirst();

            if (curr_node != null) {

                // Insert value based on direction
                if (is_order_left) {
                    level_list.addLast(curr_node.val);
                } else {
                    level_list.addFirst(curr_node.val);
                }

                // Add children to queue for next level
                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }

                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }

            } else {
                // We reached end of one level

                // Add completed level to result
                results.add(level_list);

                // Prepare for next level
                level_list = new LinkedList<>();

                // If queue still has nodes → add another null marker
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }

                // Flip direction for zigzag
                is_order_left = !is_order_left;
            }
        }

        return results;
    }
}

// TC: O(n)
// Each node processed once

// SC: O(n)
// Queue + result storage


// 1. Use queue for level order traversal.
//
// 2. Add null marker after each level.
//
// 3. Maintain a direction flag (left → right / right → left).
//
// 4. Insert values at end OR beginning of level list based on direction.
//
// 5. When null marker appears:
//    → level finished
//    → add level_list to results
//    → reset level_list
//    → flip direction
//
// 6. Continue until queue empty.
