class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        // visited[i] = have we already explored this city?
        boolean[] visited = new boolean[n];

        int provinces = 0;

        // Try to start traversal from every city
        for (int i = 0; i < n; i++) {

            // If this city is NOT visited,
            // it means we found a NEW connected component (province)
            if (!visited[i]) {

                // Explore all cities connected to 'i'
                bfs(isConnected, visited, i);

                // One full BFS = one province
                provinces++;
            }
        }

        return provinces;
    }


    // ===================== BFS =====================
    private void bfs(int[][] isConnected, boolean[] visited, int start) {

        // Queue is used to explore nodes level by level
        Queue<Integer> queue = new LinkedList<>();

        // Start from the given city
        queue.offer(start);
        visited[start] = true; // mark immediately to avoid re-adding

        while (!queue.isEmpty()) {

            int city = queue.poll(); // take current city

            // Check all possible neighbors of this city
            // (since it's an adjacency matrix, we scan the entire row)
            for (int i = 0; i < isConnected.length; i++) {

                // CONDITION:
                // 1. isConnected[city][i] == 1 → there is a connection
                // 2. !visited[i] → we haven't explored this city yet
                if (isConnected[city][i] == 1 && !visited[i]) {

                    // Mark visited BEFORE pushing (prevents duplicates)
                    visited[i] = true;

                    // Add neighbor to queue for further exploration
                    queue.offer(i);
                }
            }
        }
    }
}


/*
================= 🧠 CORE INTUITION =================

This is NOT a matrix problem.
This is a GRAPH problem.

Each city = node
Connection = edge

So the problem becomes:
→ Count number of CONNECTED COMPONENTS


================= 🔑 KEY IDEA =================

"Every time you find an unvisited node,
start BFS → that entire component = 1 province"


================= ⚡ WHY BFS WORKS =================

BFS explores ALL nodes reachable from a starting node.

So:
1 BFS call = 1 complete province covered


================= 🧠 EXECUTION FLOW =================

Example:

[1 1 0]
[1 1 0]
[0 0 1]


Start:

i = 0 → not visited
→ BFS → visits 0 and 1

visited = [T, T, F]
provinces = 1


i = 1 → already visited → skip


i = 2 → not visited
→ BFS → visits 2

visited = [T, T, T]
provinces = 2


Final Answer = 2


================= ⏱ COMPLEXITY =================

Time: O(n²)

Why?
- For each node, we scan entire row (adj matrix)


Space: O(n)

- visited array
- queue (worst case)


================= 🧠 INTERVIEW MEMORY =================

"Connected Components using BFS"

Unvisited node → start BFS → count++

================================================
*/