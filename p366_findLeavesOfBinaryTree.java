import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Find Leaves of Binary Tree
 *
 * Return all leaves of the tree level by level.
 * Each round removes current leaves and collects them.
 *
 * Example:
 *        1
 *       / \
 *      2   3
 *     / \  /
 *    4  5 6
 *
 * Output:
 * [[4,5,6], [2,3], [1]]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {

    /*
     * Main Function:
     * Repeatedly remove leaf nodes until the tree becomes empty.
     */
    public List<List<Integer>> collectLeaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // Continue until entire tree is removed
        while (root != null) {

            // List to store current round leaves
            List<Integer> leaves = new ArrayList<>();

            // Remove leaves and update root
            root = removeLeaves(root, leaves);

            // Store this round's leaves
            result.add(leaves);
        }

        return result;
    }

    /*
     * Helper Function:
     * - Identifies leaf nodes
     * - Adds them to the list
     * - Removes them by returning null
     */
    private TreeNode removeLeaves(TreeNode node, List<Integer> leaves) {

        // Base case
        if (node == null) {
            return null;
        }

        // If current node is a leaf
        if (node.left == null && node.right == null) {
            leaves.add(node.val);   // Collect leaf value
            return null;            // Remove leaf
        }

        // Recursively process left and right subtree
        node.left = removeLeaves(node.left, leaves);
        node.right = removeLeaves(node.right, leaves);

        // Return updated node after leaf removal
        return node;
    }

    /*
     * Driver Code (For Testing)
     */
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Construct sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // Execute function
        List<List<Integer>> result = solution.collectLeaves(root);

        System.out.println(result);
    }
}


/*
==================== EXECUTION SUMMARY ====================

Round 1 → Remove: [4, 5, 6]
Round 2 → Remove: [2, 3]
Round 3 → Remove: [1]

Final Output:
[[4, 5, 6], [2, 3], [1]]

Time Complexity: O(n^2) in worst case
Space Complexity: O(n)

===========================================================
*/