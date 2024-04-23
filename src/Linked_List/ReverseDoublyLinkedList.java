package Linked_List;

public class ReverseDoublyLinkedList {
    public DoublyListNode reverse(DoublyListNode head) {
        DoublyListNode prev = null;
        DoublyListNode current = head;
        DoublyListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next; // Swap the prev and next pointers for the reversed list
            prev = current;
            current = next;
        }

        return prev; // New head of the reversed list
    }

    // Utility function to print the elements of the linked list
    public void printList(DoublyListNode head) {
        DoublyListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Usage example
    public static void main(String[] args) {
        ReverseDoublyLinkedList reverser = new ReverseDoublyLinkedList();

        // Create a sample doubly linked list
        DoublyListNode head = new DoublyListNode(1);
        head.next = new DoublyListNode(2);
        head.next.prev = head;
        head.next.next = new DoublyListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DoublyListNode(4);
        head.next.next.next.prev = head.next.next;

        System.out.println("Original list:");
        reverser.printList(head);

        // Reverse the doubly linked list
        DoublyListNode reversedHead = reverser.reverse(head);

        System.out.println("Reversed list:");
        reverser.printList(reversedHead);
    }
}
