package main.java.week10.assignment_problems;

class OrderNode {
    int data;
    OrderNode next;

    public OrderNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelledOrdersCleanup {

    // Removes all nodes matching 'code' and returns the updated head
    public static OrderNode removeAll(OrderNode head, int code) {
        // Step 1: Advance head past all matching leading nodes
        while (head != null && head.data == code) {
            head = head.next;
        }

        // Step 2: Traverse remaining nodes and un-link matching elements
        OrderNode current = head;
        while (current != null && current.next != null) {
            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(OrderNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        OrderNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: 5 -> 3 -> 5 -> 8 -> 5, code = 5
        OrderNode head1 = new OrderNode(5);
        head1.next = new OrderNode(3);
        head1.next.next = new OrderNode(5);
        head1.next.next.next = new OrderNode(8);
        head1.next.next.next.next = new OrderNode(5);

        head1 = removeAll(head1, 5);
        printList(head1);

        // Sample 2: 5 -> 5 -> 5, code = 5
        OrderNode head2 = new OrderNode(5);
        head2.next = new OrderNode(5);
        head2.next.next = new OrderNode(5);

        head2 = removeAll(head2, 5);
        printList(head2);
    }
}
