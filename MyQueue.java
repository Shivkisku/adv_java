import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        /* Push onto stackNewest, which always has the newest
         * elements on top */
        stackNewest.push(value);
    }

    /* Move elements from stackNewest into stackOldest. This
     * is usually done so that we can do operations on stackOldest */
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.peek(); // Retrieve the oldest item
    }

    public T remove() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.pop(); // Remove and return the oldest item
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        // Example usage:
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        System.out.println("Peek: " + myQueue.peek()); // Peek should return 1

        System.out.println("Remove: " + myQueue.remove()); // Remove should return and remove 1

        myQueue.add(4);

        System.out.println("Peek: " + myQueue.peek()); // Peek should return 2
    }
}


// javac MyQueue.java
// java MyQueue
