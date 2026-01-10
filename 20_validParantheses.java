import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        // Map to store closing → opening bracket pairs
        HashMap<Character, Character> mappedBrackets = new HashMap<>();
        mappedBrackets.put(')', '(');
        mappedBrackets.put('}', '{');
        mappedBrackets.put(']', '[');

        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If it's an opening bracket, push onto stack
            if (!mappedBrackets.containsKey(c)) {
                stack.push(c);
            } 
            // If it's a closing bracket
            else {
                // No opening bracket available to match
                if (stack.empty()) {
                    return false;
                }

                // Check if the top opening bracket matches
                char topElement = stack.pop();
                if (topElement != mappedBrackets.get(c)) {
                    return false;
                }
            }
        }

        // Valid only if no unmatched opening brackets remain
        return stack.isEmpty();
    }
}

// TC: O(n)
// Each character is processed once.

// SC: O(n)
// Stack can store up to n characters in the worst case.

// 1. Use a HashMap to map closing brackets to their opening counterparts.
// 2. Traverse the string character by character.
// 3. Push opening brackets onto the stack.
// 4. For a closing bracket, pop from the stack and check for a match.
// 5. If any mismatch or missing opening bracket occurs, return false.
// 6. At the end, the stack must be empty for the string to be valid.
