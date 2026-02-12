class KthLargest {

    private PriorityQueue<Integer> minHeap;  // stores k largest elements
    private int k;

    public KthLargest(int k, int[] nums) {

        // Store k value
        this.k = k;

        // Min-heap of size k
        // The smallest element in heap will represent the kth largest overall
        this.minHeap = new PriorityQueue<>(k);

        // Insert initial numbers using add() logic
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        // If heap size is less than k, just insert
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }

        // If new value is bigger than the smallest in heap,
        // remove smallest and insert new value
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        // The root of minHeap is always kth largest element
        return minHeap.peek();
    }
}


// TC:
// Constructor: O(n log k)
// add(): O(log k)

// SC: O(k)
// Heap only stores k elements


// 1. Maintain a min-heap of size k.
// 2. Insert initial numbers using add() logic.
// 3. If heap size < k → insert.
// 4. If new value > smallest in heap → replace smallest.
// 5. Heap top always represents kth largest.


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */