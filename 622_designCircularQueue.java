class MyCircularQueue {

    // Array to store queue elements
    private final int[] data;

    // Maximum capacity of the queue
    private final int cap;

    // Index of the front element
    private int head;

    // Current number of elements in the queue
    private int size;

    // Constructor
    public MyCircularQueue(int k) {
        data = new int[k];   // fixed-size array
        cap = k;             // capacity
        head = 0;            // front starts at index 0
        size = 0;            // queue is initially empty
    }

    // Insert an element at the rear of the queue
    public boolean enQueue(int value) {

        // Cannot insert if queue is full
        if (isFull()) return false;

        // Calculate rear index using circular formula
        int tail = (head + size) % cap;

        data[tail] = value;
        size++;

        return true;
    }

    // Remove an element from the front of the queue
    public boolean deQueue() {

        // Cannot remove if queue is empty
        if (isEmpty()) return false;

        // Move head forward circularly
        head = (head + 1) % cap;
        size--;

        return true;
    }

    // Get the front element
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    // Get the last (rear) element
    public int Rear() {

        if (isEmpty()) return -1;

        // Rear index = (head + size - 1) % cap
        int tail = (head + size - 1) % cap;
        return data[tail];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == cap;
    }
}

// TC: O(1) for all operations
// SC: O(k) where k is queue capacity

// 1. Use a fixed-size array to store queue elements.
// 2. Keep an index `head` pointing to the front of the queue.
// 3. Maintain `size` to know how many elements are currently stored.
// 4. Compute the rear position when needed using (head + size).
// 5. Apply modulo (%) so indices wrap around the array (circular behavior).
// 6. Move pointers instead of shifting elements for O(1) operations.
