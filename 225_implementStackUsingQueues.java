class MyStack {

    // q1 will always hold the current stack order
    private Queue<Integer> q1;

    // q2 is a helper queue used during push
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {

        // Step 1: Push new element into empty helper queue
        q2.offer(x);

        // Step 2: Move all existing elements from q1 to q2
        // This ensures the new element stays at the front
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Step 3: Swap q1 and q2
        // Now q1 represents the updated stack
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes and returns the top element of the stack
    public int pop() {
        return q1.poll();
    }

    // Returns the top element without removing it
    public int top() {
        return q1.peek();
    }

    // Checks if the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}

// push(): O(n)
// pop(): O(1)
// top(): O(1)
// empty(): O(1)

// SC: O(n)

// Two queues store up to n elements.
// 1. Use two queues to simulate stack behavior.
// 2. Always maintain q1 such that its front is the stack top.
// 3. During push:
//    - Insert new element into q2.
//    - Move all elements from q1 into q2.
//    - Swap q1 and q2.
// 4. pop() and top() become O(1) because q1 is always ordered.
// 5. empty() checks if q1 is empty.

//q1 = actual stack (top at front)
//q2 = temporary helper



















/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */