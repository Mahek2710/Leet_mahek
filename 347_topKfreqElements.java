class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // If k is the entire array size, return nums directly
        if (k == nums.length) {
            return nums;
        }

        // Map to count frequency of each number
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1); //If n is already in the map →      use         its  old count    If not → use 0     Then add 1 and store back. 

        }

// Min-heap that orders numbers by their frequency (smallest frequency at top)
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
            //count.get(a) = frequency of number a

            //count.get(b) = frequency of number b

           //If a's frequency is smaller → result is negative → a goes to the top of the min-heap

         //This forces the heap to always remove the least frequent element first

        );

        // Keep only the top k most frequent elements in the heap
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }

        // Extract the k most frequent elements
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}





// TC: O(n log k)
// Building the frequency map takes O(n), pushing/removing from heap is O(log k).

// SC: O(n)
// Map stores frequency of each unique number.
// Heap stores up to k elements.


// 1. Build a frequency map for all numbers.
// 2. Use a min-heap to keep only the top k most frequent numbers.
// 3. Every time heap size exceeds k, remove the number with least frequency.
// 4. After processing all numbers, the heap contains the k most frequent ones.
// 5. Extract elements from heap to form the answer.

