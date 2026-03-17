/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Recursive function to serialize the tree
    public String recserialize(TreeNode root, String str) {

        // Base case
        if (root == null) {
            str += "null,";
        } 
        else {

            // Store current node value
            str += String.valueOf(root.val) + ",";

            // Serialize left subtree
            str = recserialize(root.left, str);

            // Serialize right subtree
            str = recserialize(root.right, str);
        }

        return str;
    }


    // Encodes a tree to a single string
    public String serialize(TreeNode root) {
        return recserialize(root, "");
    }


    // Recursive function to rebuild tree
    public TreeNode recdeserialize(List<String> strList) {

        // If node is null
        if (strList.get(0).equals("null")) {
            strList.remove(0);
            return null;
        }

        // Create node
        TreeNode root = new TreeNode(Integer.valueOf(strList.get(0)));
        strList.remove(0);

        // Build left subtree
        root.left = recdeserialize(strList);

        // Build right subtree
        root.right = recdeserialize(strList);

        return root;
    }


    // Decodes encoded string back to tree
    public TreeNode deserialize(String data) {

        String[] strArray = data.split(",");

        List<String> strList = new LinkedList<>(Arrays.asList(strArray));

        return recdeserialize(strList);
    }
}


/*
================= LOGIC / STEPS TO REMEMBER =================

Goal:
Convert a Binary Tree → String (serialize)
and String → Binary Tree (deserialize)


------------------- SERIALIZATION -------------------

STEP 1
Use Preorder traversal:

Root → Left → Right


STEP 2
For every node:

store node value


STEP 3
If node is null:

store "null"


STEP 4
Separate values using comma


Example Tree

        1
       / \
      2   3
         / \
        4   5


Serialized String

"1,2,null,null,3,4,null,null,5,null,null,"


------------------- DESERIALIZATION -------------------

STEP 1
Split string using comma


STEP 2
Store values in List


STEP 3
Read elements one by one


STEP 4
If value == "null"

return null node


STEP 5
Otherwise

create node
recursively build:

left subtree
right subtree


------------------- RECONSTRUCTION -------------------

List = [1,2,null,null,3,4,null,null,5,null,null]

1 → root

2 → left child

null → left of 2

null → right of 2

3 → right child

4 → left of 3

5 → right of 3


Tree rebuilt successfully.


================= TIME & SPACE =================

Time Complexity: O(n)

- Each node processed once
- Serialization + Deserialization


Space Complexity: O(n)

- String storage
- Recursion stack

Serialize  → Preorder + store "null"
Deserialize → Read values in same order

================================================
*/

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));