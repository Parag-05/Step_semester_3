package main.java.week10.assignment_problems;

class CoachNode {
    String name;
    CoachNode prev;
    CoachNode next;

    public CoachNode(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

public class TrainCoachesBothWays {
    private CoachNode head;
    private CoachNode tail;

    public void addLast(String name) {
        CoachNode newNode = new CoachNode(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(String name) {
        CoachNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void printForward() {
        System.out.print("Forward: ");
        CoachNode current = head;
        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward() {
        System.out.print("Backward: ");
        CoachNode current = tail;
        while (current != null) {
            System.out.print(current.name);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
