/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // Map to store already created copies
    // key   → original node
    // value → copied node
    HashMap<Node, Node> visitedNode = new HashMap<>();

    public Node copyRandomList(Node head) {

        // Base case: if original node is null, copied node is also null
        if (head == null) {
            return null;
        }

        // If this node is already copied, return its copy
        // This avoids infinite loops due to random pointers
        if (visitedNode.containsKey(head)) {
            return visitedNode.get(head);
        }

        // Create a new node with the same value
        Node node = new Node(head.val, null, null);

        // Store the copy in the map before recursive calls
        visitedNode.put(head, node);

        // Recursively copy the next pointer
        node.next = copyRandomList(head.next);

        // Recursively copy the random pointer
        node.random = copyRandomList(head.random);

        // Return the copied node
        return node;
    }
}

// TC: O(n)
// Each node is visited and copied exactly once.

// SC: O(n)
// HashMap stores a copy for each node.
// Recursion stack can also go up to n in worst case.


// 1. If the current node is null, return null.
// 2. If the node is already copied, return its copy from the map.
// 3. Create a new node with the same value as the original.
// 4. Store the mapping (original → copy) in HashMap.
// 5. Recursively copy the next pointer.
// 6. Recursively copy the random pointer.
// 7. Return the copied node.
