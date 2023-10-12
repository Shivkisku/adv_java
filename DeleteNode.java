class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNode {
    public static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            // Unable to delete if the node is null or the last node in the list
            return false;
        }

        LinkedListNode next = n.next;
        n.data = next.data;  // Copy data from the next node into the current node
        n.next = next.next;  // Skip the next node by updating the 'next' reference
        return true;
    }

    public static void main(String[] args) {
        // Example usage:
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        // Delete the second node (node with value 2)
        boolean success = deleteNode(head.next);

        if (success) {
            System.out.println("Node deleted successfully.");
        } else {
            System.out.println("Unable to delete the node.");
        }

        // Print the modified linked list
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
