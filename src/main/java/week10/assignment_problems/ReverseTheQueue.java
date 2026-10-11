package main.java.week10.assignment_problems;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseTheQueue {

    // Iterative 3-pointer reversal: O(n) Time, O(1) Space
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // store next node
            current.next = prev; // reverse pointer
            prev = current;      // move prev forward
            current = next;      // move current forward
        }

        return prev; // new head of the reversed list
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("-> null");
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> 4
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        head1 = reverse(head1);
        printList(head1);

        // Sample 2: 9
        Node head2 = new Node(9);
        head2 = reverse(head2);
        printList(head2);
    }
}