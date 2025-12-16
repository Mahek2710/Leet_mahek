class Solution {
    public int maxArea(int[] height) {

        int max = 0;

        // Start with the widest container possible
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            // Width is decided by how far apart the pointers are
            int width = right - left;

            // Height of water is limited by the shorter wall
            int area = Math.min(height[left], height[right]) * width;

            // Update answer if this container holds more water
            max = Math.max(max, area);

            // Move the shorter wall inward:
            // Keeping it will never increase area (height is the bottleneck),
            // so we try to find a taller wall instead
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}

// TC: O(n)
// Two pointers traverse the array once.

// SC: O(1)
// Only constant extra space is used.

// 1. Start with two pointers at both ends of the array.
// 2. Calculate area using the shorter height and current width.
// 3. Update the maximum area if current area is larger.
// 4. Move the pointer pointing to the shorter height.
// 5. Repeat until both pointers meet.
