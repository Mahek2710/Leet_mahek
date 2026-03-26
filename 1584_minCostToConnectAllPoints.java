import java.util.*;

class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length; // total number of points


        // Min Heap → always gives smallest distance edge
        PriorityQueue<Point> pq =
                new PriorityQueue<>((a, b) -> a.distance - b.distance);


        // Track which points are already included in MST
        boolean[] inMST = new boolean[n];


        // Start from point 0 with cost 0
        pq.offer(new Point(0, 0));


        int minCost = 0;          // total cost of MST
        int pointsConnected = 0;  // number of points added to MST


        // Keep adding points until all are connected
        while (pointsConnected < n) {

            // Get point with smallest cost
            Point current = pq.poll();


            // If already included → skip
            if (inMST[current.index]) {
                continue;
            }


            // Mark this point as included in MST
            inMST[current.index] = true;


            // Add its cost to total
            minCost += current.distance;


            // Increase count
            pointsConnected++;


            // Try connecting to all other points
            for (int i = 0; i < n; i++) {

                // Only consider points not yet in MST
                if (!inMST[i]) {

                    // Calculate Manhattan distance
                    int distance =
                            Math.abs(points[current.index][0] - points[i][0]) +
                            Math.abs(points[current.index][1] - points[i][1]);

                    // Add this edge to heap
                    pq.offer(new Point(i, distance));
                }
            }
        }

        return minCost;
    }


    // Helper class to store node + distance
    static class Point {
        int index;     // index of point
        int distance;  // cost to connect

        Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}

/*
================= 🧾 PROBLEM BRIEF =================

Connect all points with minimum total cost

Distance = Manhattan distance


================= 🧠 CORE INTUITION =================

We need Minimum Spanning Tree (MST)

→ connect all nodes with minimum cost


================= 🔑 KEY IDEA =================

Use Prim’s Algorithm:

1. Start from any node
2. Always pick smallest edge
3. Expand MST


================= 🧠 EXECUTION FLOW =================

Example:

Points:
(0,0), (2,2), (3,10)

STEP 1:
Start with (0,0)

PQ = [(0,0)]


STEP 2:
Pick (0,0)

Add neighbors:
→ (2,2) distance = 4
→ (3,10) distance = 13

PQ = [(2,2,4), (3,10,13)]


STEP 3:
Pick smallest → (2,2)

Add neighbors:
→ (3,10) distance = 9

PQ = [(3,10,9), (3,10,13)]


STEP 4:
Pick (3,10)

All points connected


TOTAL COST = 4 + 9 = 13


================= ⚠️ IMPORTANT DETAIL =================

Skip already visited:

if (inMST[node]) continue;

→ prevents cycles


================= ⏱ TIME & SPACE =================

Time: O(n² log n)

Space: O(n)


================= 🔥 MEMORY TRICK =================

"MST → always pick smallest edge"


================= 🧠 PATTERN =================

Graph + MST (Prim’s Algorithm)

================================================
*/