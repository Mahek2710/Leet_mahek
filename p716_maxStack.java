import java.util.Stack;

class MaxStack {

    // Main stack to store actual values
    private Stack<Integer> stack;

    // Auxiliary stack to keep track of max values
    private Stack<Integer> maxStack;

    // Constructor
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    // Push element x onto stack
    public void push(int x) {

        // If maxStack is empty, x itself is max
        // Otherwise, compare x with current max
        int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);

        stack.push(x);
        maxStack.push(max);
    }

    // Remove and return top element
    public int pop() {

        // Pop from both stacks to keep them in sync
        maxStack.pop();
        return stack.pop();
    }

    // Return top element without removing it
    public int top() {
        return stack.peek();
    }

    // Return the maximum element in the stack
    public int peekMax() {
        return maxStack.peek();
    }

    // Remove and return the maximum element
    public int popMax() {

        // Get current maximum
        int max = peekMax();

        // Buffer stack to temporarily store elements
        Stack<Integer> buffer = new Stack<>();

        // Move elements until max reaches the top
        while (top() != max) {
            buffer.push(pop());
        }

        // Remove the max element
        pop();

        // Push all elements back to restore order
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }

        // Return the removed maximum value
        return max;
    }
}
// push(): O(1)
// pop(): O(1)
// top(): O(1)
// peekMax(): O(1)
// popMax(): O(n)   (may move all elements)

// SC: O(n)
// Two stacks used.

// 1. Use one stack to store values.
// 2. Use another stack to track the maximum at each level.
// 3. On push, store the current maximum alongside the value.
// 4. On pop, remove from both stacks.
// 5. peekMax() gives max in O(1).
// 6. popMax() temporarily removes elements to access and delete the max.
// 7. Restore the stack after removing the max.
