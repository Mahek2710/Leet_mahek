class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible speed (at least 1 banana per hour)
        int left = 1;

        // Maximum possible speed = largest pile
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search to find the minimum valid speed
        while (left < right) {

            int mid = left + (right - left) / 2;

            // Check if Koko can finish all bananas at speed = mid
            if (canFinish(piles, mid, h)) {
                // Speed works, try slower speed
                right = mid;
            } else {
                // Speed too slow, need to eat faster
                left = mid + 1;
            }
        }

        // Left == right is the minimum speed that works
        return left;
    }

    // Helper method to check if a given speed is sufficient
    private boolean canFinish(int[] piles, int speed, int h) {

        int hours = 0;

        // Calculate total hours required at the given speed
        for (int pile : piles) {
            // Each pile takes ceil(pile / speed) hours
            hours += Math.ceil((double) pile / speed);
        }

        // Check if total hours fit within allowed time
        return hours <= h;
    }
}

// TC: O(n log m)
// n = number of piles
// m = maximum pile size

// SC: O(1)
// Constant extra space used.

// 1. The eating speed must be between 1 and the largest pile.
// 2. Apply binary search on this range of speeds.
// 3. For a given speed, compute how many hours are needed.
// 4. If total hours ≤ h, the speed is valid — try a smaller one.
// 5. If total hours > h, the speed is too slow — increase it.
// 6. When search ends, return the minimum speed that works.
