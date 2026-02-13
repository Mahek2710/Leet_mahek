import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Definition for an interval
class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        // Result list to store common free intervals
        List<Interval> result = new ArrayList<>();

        // Min-heap sorted by start time
        PriorityQueue<Interval> pq =
                new PriorityQueue<>((a, b) -> a.start - b.start);

        // Step 1: Add all intervals from all employees into the heap
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }

        // Step 2: Start with the earliest interval
        Interval prev = pq.poll();

        // Step 3: Merge intervals and find gaps
        while (!pq.isEmpty()) {

            Interval curr = pq.poll();

            // If there is a gap between prev and curr → free time
            if (prev.end < curr.start) {
                result.add(new Interval(prev.end, curr.start));

                // Move prev forward
                prev = curr;
            }
            else {
                // Overlapping intervals → merge by updating end time
                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return result;
    }
}


// TC: O(n log n)
// We insert all intervals into heap and process them.

// SC: O(n)
// Heap + result storage

// 1. Put all intervals into a min-heap sorted by start time.
// 2. Take the earliest interval as "prev".
// 3. For each next interval:
//    - If there is a gap → add free interval.
//    - Else merge overlapping intervals.
// 4. Return all gaps (common free times).

