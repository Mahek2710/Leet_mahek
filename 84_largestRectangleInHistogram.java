class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        // Traverse all bars + one extra iteration with height = 0
        for (int i = 0; i <= n; i++) {

            // For the extra iteration, use height = 0
            int currentHeight = (i == n) ? 0 : heights[i];

            // Maintain a monotonic increasing stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {

                // Height of the rectangle
                int height = heights[stack.pop()];

                // Width calculation
                // If stack is empty → rectangle spans from 0 to i
                // Else → rectangle spans from stack.peek() + 1 to i - 1
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Update maximum area
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index
            stack.push(i);
        }

        return maxArea;
    }
}

// TC: O(n)
// Each index is pushed and popped at most once.

// SC: O(n)


// Stack stores indices.
 // 1. Use a stack to store indices of bars in increasing height order.
// 2. Traverse each bar from left to right.
// 3. If the current bar is taller, push its index.
// 4. If the current bar is shorter:
//    - Pop bars from stack.
//    - For each popped bar, calculate area using it as the smallest height.
// 5. Width is determined by the distance between current index and stack top.
// 6. Add an extra iteration with height = 0 to flush remaining bars.
// 7. Track and return the maximum area.

// Stack keeps indices of increasing heights

// When a shorter bar appears → previous taller bars must end here

// Each popped bar becomes the smallest bar of a rectangle

// Heights: [2,1,5,6,2,3]
// Stack: increasing bars only



// For each bar, find the widest rectangle where it is the smallest height.
