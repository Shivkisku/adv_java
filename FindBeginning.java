class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindBeginning {
    public LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Find meeting point. This will be LOOP_SIZE - k steps into the linked list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break; // Meeting point found.
            }
        }

        // Error checking - no meeting point, and therefore no loop.
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move slow to head. Keep fast at the meeting point. Both are k steps from the loop start.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }

    public static void main(String[] args) {
        FindBeginning finder = new FindBeginning();

        // Example usage:
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating a loop

        LinkedListNode loopStart = finder.findBeginning(head);

        if (loopStart != null) {
            System.out.println("The loop starts at node with value " + loopStart.data);
        } else {
            System.out.println("There is no loop in the linked list.");
        }
    }
}


// javac FindBeginning.java
// java FindBeginning
