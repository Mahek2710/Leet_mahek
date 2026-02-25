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

    // Inorder traversal function
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {

        // Base case
        if (root == null) {
            return arr;
        }

        // Visit left subtree
        inOrder(root.left, arr);

        // Visit root
        arr.add(root.val);

        // Visit right subtree
        inOrder(root.right, arr);

        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {

        // Perform inorder traversal
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());

        // Return kth smallest (index = k-1 because 0-based indexing)
        return nums.get(k - 1);
    }
}


/*
================= COMPLETE EXECUTION FLOW =================

1. kthSmallest(root, k) is called.

2. inOrder(root, new ArrayList<>()) is executed.

3. Recursion goes:
      Left → Root → Right

4. All values get stored in sorted order
   because it is a BST.

5. Suppose inorder result is:
   [2, 3, 4, 5, 7]

6. If k = 3:
   nums.get(3 - 1) → nums.get(2) → 4

7. Return 4.


================= TIME & SPACE =================

Time Complexity: O(n)
- We traverse all nodes once.

Space Complexity: O(n)
- We store all elements in ArrayList.
- Plus recursion stack.

================================================
*/