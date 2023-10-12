class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Partition {
    public LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                // Insert the node at the head.
                node.next = head;
                head = node;
            } else {
                // Insert the node at the tail.
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        // The head has changed, so return it to the user.
        return head;
    }

    public static void main(String[] args) {
        Partition partitioner = new Partition();

        // Example usage:
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(5);
        head.next.next = new LinkedListNode(8);
        head.next.next.next = new LinkedListNode(5);
        head.next.next.next.next = new LinkedListNode(10);
        head.next.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next.next = new LinkedListNode(1);

        int x = 5;
        LinkedListNode newHead = partitioner.partition(head, x);

        // Print the partitioned linked list.
        LinkedListNode current = newHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}


// javac Partition.java
// java Partition
