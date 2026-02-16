public class MedianFinder {

    // Max heap → stores the smaller half of numbers
    // Top gives the largest element from the smaller half
    private PriorityQueue<Integer> lo =
            new PriorityQueue<>((a, b) -> b - a);

    // Min heap → stores the larger half of numbers
    // Top gives the smallest element from the larger half
    private PriorityQueue<Integer> hi =
            new PriorityQueue<>();

    /** Initialize the data structure */
    public MedianFinder() {}

    /** Add a number into the stream */
    public void addNum(int num) {

        // Step 1: Always push into max heap first
        lo.offer(num);

        // Step 2: Move the largest of small half → large half
        // This keeps ordering correct: lo ≤ hi
        hi.offer(lo.poll());

        // Step 3: Balance sizes
        // We want lo to have equal size OR one extra element
        if (lo.size() < hi.size()) {
            lo.offer(hi.poll());
        }
    }

    /** Return the median of current numbers */
    public double findMedian() {

        // If odd count → lo has one extra element → that is median
        if (lo.size() > hi.size()) {
            return lo.peek();
        }

        // If even count → average of both tops
        return (lo.peek() + hi.peek()) * 0.5;
    }
}

// addNum() → O(log n) → heap insert + poll
// findMedian() → O(1) → just peek
// SC → O(n) → storing all elements in heaps


// 1. Maintain two heaps:
//    - Max heap (lo) → smaller half
//    - Min heap (hi) → larger half
//
// 2. Always add new number to max heap first.
//
// 3. Move top of max heap to min heap
//    → ensures all elements in lo ≤ hi.
//
// 4. Rebalance sizes so:
//    lo.size() == hi.size()
//    OR lo.size() = hi.size() + 1
//
// 5. Median:
//    - If odd → lo.peek()
//    - If even → average of lo.peek() and hi.peek()


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */