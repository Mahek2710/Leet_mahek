class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // ===== EDGE CASE =====
        // If k equals the size of the array,
        // we can simply return the original array
        if (k == nums.length) {
            return nums;
        }

        // ===== STEP 1: BUILD FREQUENCY MAP =====
        // This map will store:
        // key   = number from array
        // value = how many times it appears
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            // getOrDefault(n, 0):
            // - if 'n' exists → returns its current frequency
            // - if not → returns 0
            // then we add 1 to update frequency
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // ===== STEP 2: CREATE MIN HEAP =====
        // Heap will store numbers, NOT frequencies
        // But ordering is based on frequency using the map

        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
            // Comparator explanation:
            // - number with smaller frequency comes first
            // - this makes it a MIN HEAP based on frequency
        );

        // ===== STEP 3: KEEP ONLY TOP K FREQUENT ELEMENTS =====
        for (int n : count.keySet()) {

            // Add current number into heap
            heap.add(n);

            // If heap size exceeds k:
            // remove the element with LOWEST frequency
            // (because we only want top k frequent elements)
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // ===== STEP 4: BUILD RESULT ARRAY =====
        int[] ans = new int[k];

        // Extract elements from heap
        // Note: order is not guaranteed (heap property)
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}

/*
================= 🧠 PROBLEM UNDERSTANDING =================

Goal:
- Return the k most frequent elements from the array

Key idea:
- We DON'T need all elements sorted
- We only care about the TOP k frequent ones


================= ⚙️ APPROACH OVERVIEW =================

Step 1: Count frequencies
→ Use a HashMap to store how many times each number appears

Step 2: Use a Min Heap (size = k)
→ Heap stores numbers
→ Ordering is based on frequency (using the map)

Step 3: Maintain only top k elements
→ Add each number into heap
→ If heap size becomes > k:
     remove the element with LOWEST frequency

Step 4: Extract result
→ Heap now contains k most frequent elements


================= 🔑 WHY MIN HEAP? =================

We want to REMOVE the least useful element quickly

- Least useful = lowest frequency
- Min heap gives access to smallest element in O(log k)

So:
→ Keep pushing elements
→ Remove smallest whenever size exceeds k

👉 This ensures heap always contains TOP k frequent elements


================= 🔄 DRY RUN =================

Example:
nums = [1,1,1,2,2,3], k = 2

Frequency Map:
1 → 3
2 → 2
3 → 1


Heap operations:

Add 1 → [1]

Add 2 → [2,1]   (2 has smaller freq → comes first)

Add 3 → [3,1,2]

Size > k → remove least frequent (3)

Final heap:
[2,1]


Answer:
[2,1] (order doesn't matter)


================= ⏱ TIME COMPLEXITY =================

O(n log k)

- Build map → O(n)
- Each heap operation → O(log k)
- We do it for each unique element


================= 📦 SPACE COMPLEXITY =================

O(n)

- HashMap stores frequencies
- Heap stores at most k elements


================= 🎯 ONE-LINE INTUITION =================

"Keep a min heap of size k and remove the least frequent element whenever it grows too big."

====================================================
*/