class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max-heap to always get the two heaviest stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Keep smashing the two heaviest stones
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // heaviest stone(1st element)
            int x = maxHeap.poll(); // second heaviest stone(2nd element)

            // If they are not equal, push the remaining weight back
            if (x != y) {
                maxHeap.add(y - x);
            }
        }

        // Return the last stone weight, or 0 if none remain
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

// TC: O(n log n)
// Building the heap + repeated removals/insertions.

// SC: O(n)

// Heap stores up to n elements.
// 1. Use a max-heap to always access the two largest stones.
// 2. Insert all stones into the heap.
// 3. Repeatedly remove the two largest stones.
// 4. If their weights differ, insert the difference back.
// 5. Continue until at most one stone remains.
// 6. Return the final stone weight (or 0).


// Max-heap = always know the biggest two

// Smash → difference goes back

// Repeat until only one (or none)

//Always smash the two heaviest stones first using a max-heap.
