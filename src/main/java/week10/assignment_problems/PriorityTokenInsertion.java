package main.java.week10.assignment_problems;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PriorityTokenInsertion {
    private Node head;

    // Time Complexity: O(1)
    public void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
    }

    // Time Complexity: O(n)
    public void addLast(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Time Complexity: O(k) where k is index
    public void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }
        Node newNode = new Node(token);
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("-> null");
    }

    public static void main(String[] args) {
        PriorityTokenInsertion list = new PriorityTokenInsertion();

        // Starting list: 101 -> 102 -> 103
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        // Sequence of operations: addFirst(100), addLast(104), insertAt(2, 150)
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        list.printList();
    }
}