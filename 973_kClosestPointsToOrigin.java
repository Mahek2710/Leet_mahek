class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max-heap based on distance from origin
        // Farthest point stays on top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b[0] * b[0] + b[1] * b[1],   // distance of b
                a[0] * a[0] + a[1] * a[1]    // distance of a
            )
        );

        // Traverse all points
        for (int[] point : points) {

            // Add point to heap
            maxHeap.add(point);

            // If heap grows beyond k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract k closest points from heap
        int[][] result = new int[k][2];// Result array to store k closest points,
                                       // each point has exactly 2 values: (x, y)

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}

// TC: O(n log k)
// Each insertion/removal costs log k.

// SC: O(k)
// Heap stores only k points.

// 1. Use a max-heap to keep track of the k closest points.
// 2. Distance from origin = x² + y² (no need for sqrt).
// 3. Add each point to the heap.
// 4. If heap size exceeds k, remove the farthest point.
// 5. After processing all points, heap contains k closest points.
// 6. Extract them into the result array.
