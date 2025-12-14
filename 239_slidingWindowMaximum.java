class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Deque stores indices of elements
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Maintain decreasing order in deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offer(i);

            // Store result once the first window is formed
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}


// TC: O(n)
// Each element is added and removed from the deque at most once.

// SC: O(k)
// Deque stores at most k indices at any time.

// 1. Use a deque to store indices of elements in the current window.
// 2. Remove indices from the front if they fall outside the window.
// 3. Remove indices from the back if their values are smaller than the current value.
// 4. Add the current index to the deque.
// 5. Once the window size reaches k, the front of the deque gives the maximum.
// 6. Store the maximum for each window and return the result array.
