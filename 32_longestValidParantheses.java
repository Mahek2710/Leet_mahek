import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {

        int maxLength = 0;

        // Stack stores indices
        Stack<Integer> stack = new Stack<>();

        // Base index for the first valid substring
        stack.push(-1);

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Push index of '('
                stack.push(i);
            } else {
                // Pop matching '('
                stack.pop();

                // If stack becomes empty, this ')' has no base
                if (stack.isEmpty()) {
                    // Set new base index
                    stack.push(i);
                } else {
                    // Length of current valid substring
                    maxLength = Math.max(maxLength,i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}

// TC: O(n)
// Each character is processed once.

// SC: O(n)
// Stack may store up to n indices.

// 1. Use a stack to store indices of '('.
// 2. Push -1 initially to act as a base for valid substrings.
// 3. When '(' is found, push its index.
// 4. When ')' is found, pop from stack.
// 5. If stack becomes empty, push current index as new base.
// 6. Otherwise, calculate valid length = current index - stack top.
// 7. Track the maximum valid length found.
