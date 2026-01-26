class MyQueue {

    // Deque is used because it supports stack operations:
    // push(), pop(), peek() in O(1) time
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    // Push element to the back of the queue
    public void push(int x) {
        // Always push into inStack
        inStack.push(x);
    }

    // Removes and returns the front element of the queue
    public int pop() {
        moveIfNeeded();   // Ensure outStack has the correct front
        return outStack.pop();
    }

    // Returns the front element without removing it
    public int peek() {
        moveIfNeeded();   // Ensure outStack has the correct front
        return outStack.peek();
    }

    // Checks if the queue is empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Transfers elements only when outStack is empty
    // WHY this exists:
    // - To avoid moving elements on every pop/peek
    // - Ensures amortized O(1) time complexity
    private void moveIfNeeded() {

        // If outStack already has elements,
        // its top is already the front of the queue
        if (outStack.isEmpty()) {

            // Move all elements from inStack to outStack
            // This reverses their order, making the oldest element accessible
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
// push(): O(1)
// pop(): Amortized O(1)
// peek(): Amortized O(1)
// empty(): O(1)

// SC: O(n)
// Two stacks store up to n elements.

// 1. Use two stacks: one for pushing, one for popping.
// 2. Always push new elements into inStack.
// 3. For pop/peek, move elements to outStack if it's empty.
// 4. outStack maintains correct queue order.
// 5. Each element moves at most once between stacks.
// 6. This guarantees amortized O(1) operations.

//Deque is used cause :  Stack is synchronized (slower, legacy class)
// Deque (ArrayDeque) is faster and recommended
// Supports stack behavior cleanly:
// push(), pop(), peek()









/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */