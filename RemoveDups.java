import java.util.HashSet;

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDups {
    void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(3);

        RemoveDups remover = new RemoveDups();
        remover.deleteDups(head);

        // Print the modified linked list to check for duplicates.
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}


//  javac RemoveDups.java
// java RemoveDups