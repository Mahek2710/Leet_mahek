import java.util.*;

class Solution {

    // ===== COLORS FOR DFS STATES =====
    // WHITE → not visited yet
    // GRAY  → currently in recursion stack (path)
    // BLACK → fully processed (safe node)
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;                   // becomes false if cycle detected
    Map<Integer, Integer> color;         // node → state (WHITE/GRAY/BLACK)
    Map<Integer, List<Integer>> adjList; // graph representation
    List<Integer> topoOrder;             // stores result in reverse order


    // ===== INITIALIZE EVERYTHING =====
    private void init(int n) {

        isPossible = true;

        color = new HashMap<>();
        adjList = new HashMap<>();
        topoOrder = new ArrayList<>();

        // Initially, all nodes are unvisited
        for (int i = 0; i < n; i++) {
            color.put(i, WHITE);
        }
    }


    // ===== DFS FUNCTION =====
    private void dfs(int node) {

        // If cycle already found → stop further work
        if (!isPossible) return;


        // Mark node as "in current path"
        color.put(node, GRAY);


        // Explore all neighbors (courses that depend on this node)
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {

            // If neighbor not visited → go deeper
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            }

            // If neighbor is already in current path → cycle found
            else if (color.get(neighbor) == GRAY) {
                isPossible = false;
            }
        }


        // Done exploring all dependencies → mark as safe
        color.put(node, BLACK);

        // Add AFTER exploring neighbors
        // (post-order → ensures dependencies come before)
        topoOrder.add(node);
    }


    // ===== MAIN FUNCTION =====
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        init(numCourses);


        // ===== BUILD GRAPH =====
        // If [a, b] → b must be done before a
        // So edge: b → a
        for (int[] pre : prerequisites) {

            int dest = pre[0]; // course to take
            int src = pre[1];  // prerequisite

            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);
        }


        // ===== RUN DFS FOR ALL COURSES =====
        for (int i = 0; i < numCourses; i++) {

            // Only start DFS from unvisited nodes
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }


        // ===== IF CYCLE FOUND =====
        if (!isPossible) {
            return new int[0];
        }


        // ===== BUILD FINAL ANSWER =====
        int[] order = new int[numCourses];

        // Reverse post-order to get correct topological order
        for (int i = 0; i < numCourses; i++) {
            order[i] = topoOrder.get(numCourses - i - 1);
        }

        return order;
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Given:
- numCourses
- prerequisites (u, v → u depends on v)

Return:
Order in which courses can be completed

If impossible → return empty array


================= 🧠 CORE INTUITION =================

This is TOPOLOGICAL SORT + CYCLE DETECTION

If graph has cycle:
→ No valid ordering exists


================= 🔑 KEY IDEA =================

1. Use DFS
2. Track recursion path using colors
3. Detect cycle using GRAY nodes
4. Add nodes in post-order
5. Reverse result


================= 🧠 EXECUTION FLOW =================

Example:

[1,0], [2,0], [3,1], [3,2]

Graph:

0 → 1 → 3
 \       ↑
  → 2 ----


DFS:

Start 0
→ go 1 → go 3 → add 3
→ back → add 1
→ go 2 → add 2
→ add 0

Topo (reverse):
[0,2,1,3]


================= ⚠️ IMPORTANT DETAIL =================

GRAY node → cycle

Why?
Because it means we revisited a node
in the SAME recursion path


================= ⏱ TIME & SPACE =================

Time: O(V + E)

Space: O(V)

- recursion stack
- color map


================= 🔥 MEMORY TRICK =================

"GRAY = cycle"

"Post-order → reverse → answer"


================= 🧠 PATTERN =================

Graph + DFS + Topological Sort

Used in:
- Course Schedule II
- Build Order Problems
- Dependency resolution

DFS + detect cycle + store nodes AFTER exploring
================================================
*/