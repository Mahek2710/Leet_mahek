class Solution {

    public int countComponents(int n, int[][] edges) {

        int counter = 0; // number of connected components

        // visited[i] = 1 means node i is already visited
        int[] visited = new int[n];

        // Adjacency list to represent graph
        List<Integer>[] adjList = new ArrayList[n];

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Build graph (undirected)
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            // Since undirected → add both ways
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // Traverse all nodes
        for (int i = 0; i < n; i++) {

            // If node not visited → new component found
            if (visited[i] == 0) {

                counter++; // new connected component

                // Explore entire component
                dfs(adjList, visited, i);
            }
        }

        return counter;
    }


    // ===================== DFS =====================
    public void dfs(List<Integer>[] adjList, int[] visited, int node) {

        // Mark current node as visited
        visited[node] = 1;

        // Explore all neighbors
        for (int i = 0; i < adjList[node].size(); i++) {

            int neighbor = adjList[node].get(i);

            // If neighbor not visited → go deeper
            if (visited[neighbor] == 0) {
                dfs(adjList, visited, neighbor);
            }
        }
    }
}


/*
================= 🧾 PROBLEM BRIEF =================

Given:
- n nodes (0 to n-1)
- edges representing connections

Find number of CONNECTED COMPONENTS


================= 🧠 CORE INTUITION =================

Graph problem:

Each node = vertex
Each edge = connection

Goal:
→ Count how many separate groups exist


================= 🔑 KEY IDEA =================

"Every unvisited node starts a new DFS → that’s one component"


================= 🧠 EXECUTION FLOW =================

Example:

n = 5
edges = [[0,1],[1,2],[3,4]]


Graph:

0 — 1 — 2      3 — 4


STEP 1:
i = 0 → not visited

DFS:
visit 0 → 1 → 2

visited = [1,1,1,0,0]

components = 1


STEP 2:
i = 1,2 → already visited → skip


STEP 3:
i = 3 → not visited

DFS:
visit 3 → 4

visited = [1,1,1,1,1]

components = 2


FINAL ANSWER = 2


================= ⏱ TIME & SPACE =================

Time Complexity: O(n + e)

- n = nodes
- e = edges
- Each node & edge processed once


Space Complexity: O(n + e)

- adjacency list
- recursion stack


================= 🔥 MEMORY TRICK =================

"Unvisited node → DFS → component++"

Same as:
- Number of Provinces
- Number of Islands


Unvisited node → DFS → count++
================================================
*/

