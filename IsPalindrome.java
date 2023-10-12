import java.util.Stack;

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IsPalindrome {
    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        // Push elements from the first half of the linked list onto the stack.
        // When the fast runner (which is moving at 2x speed) reaches the end of the linked list,
        // we know we're at the middle.
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If there's an odd number of elements, skip the middle element.
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the second half of the linked list with the elements in the stack.
        while (slow != null) {
            int top = stack.pop().intValue();

            // If values are different, it's not a palindrome.
            if (top != slow.data) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome checker = new IsPalindrome();

        // Example usage:
        LinkedListNode head1 = new LinkedListNode(1);
        head1.next = new LinkedListNode(2);
        head1.next.next = new LinkedListNode(2);
        head1.next.next.next = new LinkedListNode(1);

        boolean result1 = checker.isPalindrome(head1);
        System.out.println("Is the first linked list a palindrome? " + result1);

        LinkedListNode head2 = new LinkedListNode(1);
        head2.next = new LinkedListNode(2);
        head2.next.next = new LinkedListNode(3);

        boolean result2 = checker.isPalindrome(head2);
        System.out.println("Is the second linked list a palindrome? " + result2);
    }
}


// javac IsPalindrome.java
// java IsPalindrome
