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

    public int goodNodes(TreeNode root) {

        // Start DFS traversal.
        // Initialize maxSoFar to smallest integer value
        // so root is always compared properly.
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {

        // Base Case:
        // If node is null, no good nodes here.
        if (node == null) {
            return 0;
        }

        int count = 0;

        // Check if current node is a "good node".
        // A node is good if its value is >= maximum value
        // seen from root to this node.
        if (node.val >= maxSoFar) {

            // Current node is good.
            count = 1;

            // Update maxSoFar for this path.
            maxSoFar = node.val;
        }

        // Recursively count good nodes in left subtree.
        count += countGoodNodes(node.left, maxSoFar);

        // Recursively count good nodes in right subtree.
        count += countGoodNodes(node.right, maxSoFar);

        // Return total good nodes from:
        // current node + left subtree + right subtree.
        return count;
    }
}


// ===== Execution Flow Summary =====
//
// 1. Start DFS from root.
// 2. Maintain max value seen so far along each path.
// 3. If current node >= maxSoFar → it is a good node.
// 4. Update maxSoFar for that path.
// 5. Recursively check left and right subtrees.
// 6. Sum all good nodes and return total.
//
// Time Complexity: O(n)
// Each node is visited exactly once.
//
// Space Complexity: O(h)
// h = height of the tree (recursive call stack).


// ===== Execution Flow Explanation =====

// 1. goodNodes(root) is called.

// 2. It calls helper function:
//    countGoodNodes(root, Integer.MIN_VALUE)
//    → We start traversal from root.
//    → maxSoFar is initialized to the smallest possible integer
//      so the root node will always be considered first comparison.


// ===== Inside countGoodNodes(node, maxSoFar) =====

// 3. Base Case:
//    If node == null
//    → We reached beyond a leaf node
//    → Return 0 (no good node here)


// 4. Initialize count = 0
//    → This will track whether current node is good (1) or not (0)


// 5. Check if current node is a "good node":
//    Condition: node.val >= maxSoFar
//    → This means current node value is greater than or equal to
//      every value seen from root to this node.

//    If true:
//       - Set count = 1 (current node is good)
//       - Update maxSoFar = node.val
//         (because this becomes the new maximum for this path)


// 6. Recursively check left subtree:
//    count += countGoodNodes(node.left, maxSoFar)
//    → Pass updated maxSoFar for that path


// 7. Recursively check right subtree:
//    count += countGoodNodes(node.right, maxSoFar)
//    → Again pass updated maxSoFar


// 8. Return total count:
//    → Current node contribution (0 or 1)
//    + left subtree good nodes
//    + right subtree good nodes



// ===== How the Algorithm Progresses =====

// - We perform a Depth First Search (DFS).
// - While moving down each path, we keep track of the maximum value seen so far.
// - A node is "good" if its value is >= max value seen on that path.
// - Each recursive call works independently for its path.
// - Finally, we sum up all good nodes in the tree.


// Time Complexity: O(n)
// Each node is visited exactly once.

// Space Complexity: O(h)
// h = height of tree (recursive stack space).