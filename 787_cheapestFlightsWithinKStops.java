class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // लागत array: minimum cost to reach each node
        int[] costs = new int[n];

        // Initialize all costs to infinity
        java.util.Arrays.fill(costs, Integer.MAX_VALUE);

        // Cost to reach source is 0
        costs[src] = 0;

        // We can relax edges at most (k + 1) times
        // (because k stops means k+1 edges)
        for (int i = 0; i <= k; i++) {

            // Clone current costs to avoid overwriting in same iteration
            int[] temp = costs.clone();

            // Traverse all flights (edges)
            for (int[] flight : flights) {

                int u = flight[0];   // from
                int v = flight[1];   // to
                int cost = flight[2]; // price

                // If source node u is unreachable, skip
                if (costs[u] == Integer.MAX_VALUE) {
                    continue;
                }

                // Relaxation step
                if (temp[v] > costs[u] + cost) {
                    temp[v] = costs[u] + cost;
                }
            }

            // Update costs after this iteration
            costs = temp;
        }

        // If destination is still unreachable, return -1
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}


/*
==================== EXECUTION FLOW ====================

1. Initialize costs:
   - costs[src] = 0
   - all others = ∞

2. Repeat (k + 1) times:
   - For each flight (u → v):
     → Try to update cost[v] using cost[u] + price

3. Use temp array:
   - Prevents using updated values within same iteration
   - Ensures we only consider paths with ≤ k stops

4. After all iterations:
   - costs[dst] contains minimum cost within k stops

5. If still ∞ → return -1


==================== KEY IDEA ====================

- This is a variation of Bellman-Ford
- We limit relaxation to (k + 1) edges
- Each iteration allows one more edge in path


==================== COMPLEXITY ====================

Time Complexity: O(k * E)
- E = number of flights

Space Complexity: O(n)

==================================================
*/