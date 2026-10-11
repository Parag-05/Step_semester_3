package main.java.week10.assignment_problems;

class PlayerNode {
    String name;
    PlayerNode next;

    public PlayerNode(String name) {
        this.name = name;
        this.next = null;
    }
}

public class RoundRobinGameTurns {
    private PlayerNode tail;

    // Time Complexity: O(1) using tail reference
    public void addLast(String name) {
        PlayerNode newNode = new PlayerNode(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Point to itself to form circular list
        } else {
            newNode.next = tail.next; // Tail's next points to head
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Time Complexity: O(turns)
    public void printTurns(int turns) {
        if (tail == null || turns <= 0) {
            return;
        }

        PlayerNode current = tail.next; // Head of circular list
        for (int i = 0; i < turns; i++) {
            System.out.print(current.name + (i < turns - 1 ? " " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RoundRobinGameTurns game = new RoundRobinGameTurns();

        // Input players: Asha, Ravi, Neha
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        // Print 7 turns
        game.printTurns(7);
    }
}