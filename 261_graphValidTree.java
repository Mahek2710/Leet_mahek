class Solution {

    public boolean validTree(int n, int[][] edges) {

        // ===== CONDITION 1: TREE MUST HAVE EXACTLY (n - 1) EDGES =====
        // If edges are not (n - 1), it can't be a valid tree
        // (either cycle exists OR graph is disconnected)
        if (edges.length != n - 1) {
            return false;
        }


        // ===== BUILD GRAPH (ADJACENCY LIST) =====
        List<List<Integer>> adjacencyList = new ArrayList<>();

        // Initialize list for each node
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges (undirected graph → both directions)
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }


        // ===== DFS USING STACK =====
        Stack<Integer> stack = new Stack<>();

        // To track visited nodes
        HashSet<Integer> visited = new HashSet<>();


        // Start from node 0
        stack.push(0);
        visited.add(0);


        while (!stack.isEmpty()) {

            int node = stack.pop();

            // Explore all neighbors
            for (int neighbour : adjacencyList.get(node)) {

                // If already visited → skip
                if (visited.contains(neighbour)) {
                    continue;
                }

                // Mark visited BEFORE pushing (avoid duplicates)
                visited.add(neighbour);

                // Add to stack for further DFS
                stack.push(neighbour);
            }
        }


        // ===== CONDITION 2: GRAPH MUST BE FULLY CONNECTED =====
        // All nodes must be visited
        return visited.size() == n;
    }
}


/*
================= 🧾 PROBLEM BRIEF =================

Given:
- n nodes
- edges

Check if graph is a VALID TREE


================= 🧠 WHAT IS A TREE? =================

A graph is a tree if:

1️⃣ It has NO cycles
2️⃣ It is FULLY connected


================= 🔑 KEY OBSERVATION =================

For a tree:

Edges = n - 1

👉 This guarantees NO cycles


So we check:

1. edges.length == n - 1
2. graph is connected


================= 🧠 EXECUTION FLOW =================

Example:

n = 5
edges = [[0,1],[0,2],[0,3],[1,4]]


STEP 1:
edges = 4 → n - 1 = 4 ✔️


STEP 2: Build graph

      0
    / | \
   1  2  3
   |
   4


STEP 3: DFS

Start from 0:

visit → 0
→ push 1,2,3

visit → 3
visit → 2
visit → 1 → push 4
visit → 4

visited = [0,1,2,3,4]


STEP 4:
visited.size() == n ✔️

→ return true


================= ⏱ TIME & SPACE =================

Time Complexity: O(n + e)

- build graph → O(e)
- DFS → O(n + e)


Space Complexity: O(n + e)

- adjacency list
- visited set
- stack


================= 🔥 MEMORY TRICK =================

"Tree = n-1 edges + fully connected"


OR

Check:
1. edges == n-1
2. DFS visits all nodes


================================================
*/