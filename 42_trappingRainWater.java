class Solution {
    public int trap(int[] height) {

        // Two pointers starting from both ends
        int left = 0;
        int right = height.length - 1;

        int total = 0;

        // Track the tallest wall seen so far from left and right
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {

            // Decide which side to process based on smaller height
            if (height[left] < height[right]) {

                // Update leftMax if we found a taller wall
                leftMax = Math.max(leftMax, height[left]);

                // Water trapped at this position depends on leftMax
                // (because right side is guaranteed taller here)
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                }

                left++; // move inward
            } 
            else {

                // Update rightMax if we found a taller wall
                rightMax = Math.max(rightMax, height[right]);

                // Water trapped at this position depends on rightMax
                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                }

                right--; // move inward
            }
        }

        return total;
    }
}

//Core Insight:

// Water trapped at any position is decided by the shorter side of the boundary.

// That’s why:

// If height[left] < height[right] → left side is the bottleneck

// Else → right side is the bottleneck

// You never need both sides at once.

//leftMax - height[left] → water trapped at left

// rightMax - height[right] → water trapped at right

// TC: O(n)
// Each pointer moves only inward once.

// SC: O(1)
// No extra space used.

// 1. Start with two pointers at both ends of the array.
// 2. Track the tallest wall seen so far from left and right.
// 3. Always process the side with the smaller height.
//    (That side limits how much water can be trapped.)
// 4. At each step, trapped water = maxHeightSoFar - currentHeight.
// 5. Add trapped water to total.
// 6. Move the pointer inward.
// 7. Continue until pointers meet.
