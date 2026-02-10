class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Traverse all numbers
        for (int num : nums) {

            // Add current number to heap
            minHeap.add(num);

            // If heap size exceeds k, remove the smallest element
            // This ensures the heap always stores only the k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the min-heap is the kth largest element
        return minHeap.peek();
    }
}

// TC: O(n log k)
// Each insertion/removal from heap costs log k.

// SC: O(k)
// Heap stores only k elements.

// 1. Use a min-heap to track the k largest elements.
// 2. Insert each number into the heap.
// 3. If heap size becomes greater than k, remove the smallest element.
// 4. After processing all elements, heap contains exactly k largest values.
// 5. The smallest among them (heap top) is the kth largest element.


// Keep only k biggest numbers

// Throw away smaller ones immediately

// Min-heap top = kth largest

// Example:

// nums = [3,2,1,5,6,4], k = 2
// Heap ends as [5,6]
// Answer = 5

