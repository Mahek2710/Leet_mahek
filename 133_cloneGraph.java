/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    // 🔑 VERY IMPORTANT:
    // This map stores: original node → cloned node
    // WHY?
    // 1. Prevent infinite loops (graph may have cycles)
    // 2. Avoid cloning same node multiple times
    HashMap<Node, Node> visited = new HashMap<>();


    public Node cloneGraph(Node node) {

        // ===== BASE CASE =====
        // If input graph is empty
        if (node == null) {
            return null;
        }


        // ===== ALREADY CLONED CHECK =====
        // If we have already cloned this node earlier,
        // just return the clone (important for cycles)
        if (visited.containsKey(node)) {
            return visited.get(node);
        }


        // ===== CREATE CLONE NODE =====
        // Create a new node with same value
        // Neighbors list is initially empty
        Node cloneNode = new Node(node.val, new ArrayList<>());


        // ===== STORE IN MAP BEFORE DFS =====
        // CRUCIAL STEP:
        // We store it BEFORE exploring neighbors
        // → prevents infinite recursion in cyclic graphs
        visited.put(node, cloneNode);


        // ===== CLONE NEIGHBORS =====
        // For each neighbor of original node:
        for (Node neighbor : node.neighbors) {

            // Recursively clone neighbor
            // and add it to cloneNode's neighbors
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }


        // Return cloned node
        return cloneNode;
    }
}


/*
================= 🧾 PROBLEM BRIEF =================

Given a node of a graph,
return a deep copy (clone) of the graph.

Deep copy means:
- New nodes created
- Same structure
- No shared references with original graph


================= 🧠 CORE INTUITION =================

This is a GRAPH + DFS problem.

Challenge:
Graph may contain cycles

So:
→ We cannot blindly DFS
→ Need a way to track already visited nodes


================= 🔑 KEY IDEA =================

Use HashMap:

Original Node → Cloned Node

This helps:
1. Avoid infinite loops
2. Reuse already created clones


================= 🧠 EXECUTION FLOW =================

Example:

1 — 2
|   |
4 — 3


STEP 1:
cloneGraph(1)

→ create clone(1)
→ store in map


STEP 2:
Go to neighbor 2

→ create clone(2)
→ store in map


STEP 3:
From 2 → go to 1 again

BUT:
already in map → return clone(1)

→ prevents infinite recursion


STEP 4:
Continue until all nodes cloned

Graph is rebuilt fully


================= ⚠️ CRITICAL STEP =================

visited.put(node, cloneNode);

👉 MUST be done BEFORE recursion

Otherwise:
→ infinite loop
→ stack overflow


================= ⏱ TIME & SPACE =================

Time Complexity: O(V + E)

- Visit each node and edge once


Space Complexity: O(V)

- HashMap (visited)
- Recursion stack


================= 🔥 MEMORY TRICK =================

"Clone → store → then explore neighbors"

OR

"Visited map prevents cycles"

->This pattern =

DFS + HashMap (visited)

Used in:

Clone Graph
Copy Random Pointer
Deep Copy problems

================================================
*/ 