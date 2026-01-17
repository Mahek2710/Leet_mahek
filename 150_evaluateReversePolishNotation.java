class Solution {
    public int evalRPN(String[] tokens) {

        // Stack to store operands
        Stack<Integer> stack = new Stack<>();

        // Process each token in the expression
        for (String token : tokens) {

            // If token is an operator, apply it to top two operands
            if (isOperator(token)) {

                // IMPORTANT:
                // Pop second operand first, then first operand
                int b = stack.pop();
                int a = stack.pop();

                // Apply the operator
                int result = applyOperator(token, a, b);

                // Push the result back onto the stack
                stack.push(result);
            } 
            // If token is a number, push it directly
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result will be the only value left in the stack
        return stack.pop();
    }

    // Checks if the token is a valid operator
    private boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }

    // Applies the operator to two operands
    private int applyOperator(String operator, int a, int b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division (truncates toward zero)
            default:
                throw new IllegalArgumentException("Invalid Operator!");
        }
    }
}

// TC: O(n)
// Each token is processed once.

// SC: O(n)
// Stack can store up to n operands.


// 1. Use a stack to store numbers.
// 2. Traverse tokens one by one.
// 3. If token is a number, push it onto the stack.
// 4. If token is an operator:
//    - Pop two numbers from the stack.
//    - Apply the operator.
//    - Push the result back.
// 5. After processing all tokens, the stack contains one final result.
// 6. Return that result.
