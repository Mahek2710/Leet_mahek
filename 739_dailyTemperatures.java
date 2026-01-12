class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        // Answer array where answer[i] = days to wait for a warmer temperature
        int[] answer = new int[n];

        // Stack to store indices of days (monotonic decreasing stack)
        Stack<Integer> stack = new Stack<>();

        // Traverse each day
        for (int i = 0; i < n; i++) {

            // While current temperature is warmer than the day on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int index = stack.pop();

                // Number of days waited for a warmer temperature
                answer[index] = i - index;
            }

            // Push current day index onto stack
            stack.push(i);
        }

        // Remaining indices in stack have no warmer future day → answer stays 0
        return answer;
    }
}

// TC: O(n)
// Each index is pushed and popped at most once.

// SC: O(n)

// Stack can hold up to n indices.
// 1. Use a stack to store indices of unresolved days.
// 2. Traverse temperatures day by day.
// 3. If current day is warmer than the day at stack top,
//    resolve that day by calculating the difference in indices.
// 4. Continue until stack top is warmer or stack is empty.
// 5. Push current day index onto stack.
// 6. Days left in stack have no warmer future day (answer = 0).

// Temperatures: 73 74 75 71 69 72 76 73
// Stack (indices): keeps decreasing temperatures

