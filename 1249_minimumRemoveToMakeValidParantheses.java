class Solution {
    public String minRemoveToMakeValid(String s) {

        // Stores indices of characters that must be removed
        Set<Integer> removeIndices = new HashSet<>();

        // Stack to store indices of unmatched '('
        Stack<Integer> stack = new Stack<>();

        // First pass: identify invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Store index of opening bracket
                stack.push(i);
            } 
            else if (c == ')') {
                // If no matching '(', this ')' is invalid
                if (stack.isEmpty()) {
                    removeIndices.add(i);
                } 
                // Otherwise match it with an opening bracket
                else {
                    stack.pop();
                }
            }
        }

        // Any remaining '(' in stack are unmatched → mark for removal
        while (!stack.isEmpty()) {
            removeIndices.add(stack.pop());
        }

        // Second pass: build result string excluding invalid indices
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndices.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}

// TC: O(n)
// Two passes over the string.

// SC: O(n)
// Stack + HashSet can store up to n indices.

// 1. Traverse the string and track indices of '(' using a stack.
// 2. For ')':
//    - If stack is empty → mark index for removal.
//    - Else → pop matching '('.
// 3. After traversal, remaining '(' in stack are invalid → mark them.
// 4. Build a new string skipping all marked indices.
// 5. Return the valid string.
