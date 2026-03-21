class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        // parent[i] tells who is the parent (representative) of node i
        // Initially: every node is its own parent → all are separate components
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        // Process edges one by one
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Find ultimate parent (root) of both nodes
            int rootU = find(parent, u);
            int rootV = find(parent, v);


            // 🔴 CRUCIAL CHECK:
            // If both nodes have SAME root → already connected
            // Adding this edge will form a cycle → this is the answer
            if (rootU == rootV) {
                return edge;
            }

            // Otherwise, connect the two components
            // (merge sets by pointing one root to the other)
            parent[rootV] = rootU;
        }

        // Should never reach here as per problem constraints
        return new int[0];
    }


    // Find the root (ultimate parent) of a node
    private int find(int[] parent, int node) {

        // Keep going up until node is its own parent (root)
        while (node != parent[node]) {

            // 🔥 PATH COMPRESSION:
            // Make node directly point to its grandparent
            // → reduces tree height → faster future finds
            parent[node] = parent[parent[node]];

            node = parent[node];
        }

        return node; // root of the set
    }
}
/*
================= 🧾 PROBLEM BRIEF =================

Given a graph that started as a tree,
one extra edge was added.

Return that edge which creates a cycle
(i.e., redundant connection).

For each edge:
    → find root of both nodes
    → if same → cycle → return edge
    → else → union them
"Same root before union = cycle"


================= 🧠 CORE INTUITION =================

Tree property:
- n nodes → n-1 edges
- No cycles

If we add one extra edge → cycle appears


================= 🔑 KEY IDEA =================

Use Union-Find:

Before adding edge:
→ Check if both nodes already connected

If YES → cycle → return edge
If NO → union them


================= 🧠 EXECUTION FLOW =================

Example:

edges = [[1,2],[1,3],[2,3]]


STEP 1:
parent = [0,1,2,3]

Edge [1,2]:
root1 = 1, root2 = 2 → different
→ union → parent[2] = 1


STEP 2:
Edge [1,3]:
root1 = 1, root2 = 3 → different
→ union → parent[3] = 1


STEP 3:
Edge [2,3]:

find(2) → root = 1
find(3) → root = 1

Same root → cycle detected

RETURN [2,3]


================= ⏱ TIME & SPACE =================

Time Complexity: O(n * α(n))

- α(n) = inverse Ackermann (almost constant)
- Due to path compression


Space Complexity: O(n)

- parent array


================= 🔥 MEMORY TRICK =================

"Same root → cycle"

OR

"Before union → check if already connected"


================================================
*/