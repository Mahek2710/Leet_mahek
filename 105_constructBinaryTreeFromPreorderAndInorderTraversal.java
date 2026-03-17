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

    // Pointer to track current index in preorder traversal
    int preorderIndex;

    // Map to quickly find index of a value in inorder traversal
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Start from first element in preorder
        preorderIndex = 0;

        // Store inorder value → index mapping
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Build tree recursively
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    // Recursive function to construct the tree
    public TreeNode arrayToTree(int[] preorder, int left, int right) {

        // Base case: no elements in this subtree
        if (left > right) {
            return null;
        }

        // Pick current root from preorder
        int rootValue = preorder[preorderIndex];
        preorderIndex++;

        // Create root node
        TreeNode root = new TreeNode(rootValue);

        // Build left subtree
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);

        // Build right subtree
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}


/*
================= LOGIC / STEPS TO REMEMBER =================

STEP 1 — Understand the traversals

Preorder  : Root → Left → Right
Inorder   : Left → Root → Right

So:
- Preorder always gives the NEXT ROOT.
- Inorder tells where LEFT and RIGHT subtree split.


STEP 2 — First preorder element is root

Example:

preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]

First element in preorder → ROOT = 3


STEP 3 — Locate root in inorder

inorder = [9,3,15,20,7]
            ↑
           root

Elements left of root → LEFT subtree
Elements right of root → RIGHT subtree


STEP 4 — Build Left Subtree

Call recursion using inorder boundaries:

left side = (left → rootIndex - 1)

Next preorder value automatically becomes
the root of this subtree.


STEP 5 — Build Right Subtree

Call recursion using:

right side = (rootIndex + 1 → right)


STEP 6 — Stop Condition

If:

left > right

then there is no node → return null.


STEP 7 — Repeat Recursively

Process continues:

Root
 ├── Left subtree
 └── Right subtree


================= COMPLETE EXECUTION FLOW =================

Example:

preorder = [3,9,20,15,7]
inorder  = [9,3,15,20,7]


1. Root = 3
   Left subtree = [9]
   Right subtree = [15,20,7]

2. Build left
   root = 9

3. Build right
   root = 20

4. Left of 20 = 15
5. Right of 20 = 7


Final Tree:

        3
       / \
      9   20
         /  \
        15   7


================= TIME & SPACE =================

Time Complexity: O(n)
- Each node processed once
- HashMap lookup O(1)

Space Complexity: O(n)
- HashMap storage
- Recursion stack

================================================
*/