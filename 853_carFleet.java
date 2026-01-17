public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Each car is represented as:
        // cars[i][0] → starting position
        // cars[i][1] → time required to reach the target
        double[][] cars = new double[n][2];

        // Compute time to reach target for every car
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars by position in descending order
        // (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;
        double prevTime = 0;

        // Traverse cars from closest to farthest
        for (double[] car : cars) {

            // If this car takes longer than the fleet ahead,
            // it cannot catch up → forms a new fleet
            if (car[1] > prevTime) {
                count++;
                prevTime = car[1];
            }

            // Else: this car joins the fleet ahead
        }

        return count;
    }
}


// TC: O(n log n)
// Sorting the cars by position dominates.

// SC: O(n)
// Extra array used to store position and time.


// 1. For each car, compute the time needed to reach the target.
// 2. Sort cars by starting position from closest to farthest.
// 3. Traverse cars in this order.
// 4. Keep track of the maximum arrival time seen so far.
// 5. If a car’s time is greater than the previous time,
//    it forms a new fleet.
// 6. Otherwise, it merges with the fleet ahead.
// 7. Return the total number of fleets.

