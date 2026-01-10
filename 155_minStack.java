class MinStack {

    // Head of the linked list (top of the stack)
    private Node head;

    // Initialize the data structure
    public MinStack() {
        // head is initially null
    }

    // Push a new value onto the stack
    public void push(int val) {

        // If stack is empty, min is the value itself
        if (head == null) {
            head = new Node(val, val, null);
        } 
        // Otherwise, store the minimum so far
        else {
            head = new Node(
                val,                      // current value
                Math.min(val, head.min),  // minimum till this node
                head                      // link to previous top
            );
        }
    }

    // Remove the top element from the stack
    public void pop() {
        head = head.next;
    }

    // Return the top element of the stack
    public int top() {
        return head.val;
    }

    // Return the minimum element in the stack
    public int getMin() {
        return head.min;
    }

    // Node structure for stack
    private class Node {
        int val;    // value stored at this node
        int min;    // minimum value till this node
        Node next;  // pointer to the next node

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
