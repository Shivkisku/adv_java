class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NthToLast {
    LinkedListNode nthToLast(LinkedListNode head, int k) {
        if (k <= 0)
            return null;

        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // Move p2 forward k nodes into the list
        for (int i = 0; i < k - 1; i++) {
            if (p2 == null)
                return null; // Error check
            p2 = p2.next;
        }

        if (p2 == null)
            return null;

        /* Now, move p1 and p2 at the same speed. When p2 hits the end,
         * p1 will be at the right element */
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        NthToLast finder = new NthToLast();
        int k = 2; // Change k to the desired value

        LinkedListNode result = finder.nthToLast(head, k);

        if (result != null) {
            System.out.println("The " + k + "th to last element is: " + result.data);
        } else {
            System.out.println("The " + k + "th to last element is not found.");
        }
    }
}
