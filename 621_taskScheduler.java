import java.util.*;

class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Build a max heap based on task frequency
        // We want to always execute the task with highest remaining count
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        maxHeap.addAll(freqMap.values());

        int time = 0;

        // Step 3: Process tasks in cycles of (n + 1)
        while (!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            // Try to execute up to (n + 1) different tasks
            for (int i = 0; i < n + 1; i++) {

                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            // Decrease frequency of executed tasks
            for (int freq : temp) {

                freq--;

                // If task still has remaining count,
                // add it back to heap
                if (freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // Step 4: Update time
            // If heap is empty → only count actual tasks
            // If heap not empty → full cycle (n + 1)
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return time;
    }
}
// TC: O(n log k)
// n = number of tasks
// k = number of unique tasks

// SC: O(k)
// Heap + frequency map

// 1. Count frequency of each task.
// 2. Put frequencies in a max heap.
// 3. Process tasks in cycles of (n + 1).
// 4. In each cycle, execute up to (n + 1) tasks.
// 5. Decrease their frequencies.
// 6. Reinsert unfinished tasks into heap.
// 7. Update total time accordingly.
