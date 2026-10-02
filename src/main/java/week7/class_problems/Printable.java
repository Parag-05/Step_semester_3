package main.java.week7.class_problems;

public interface Printable {
    String printLabel();

    static void printAll(Printable[] items) {
        if (items != null) {
            for (Printable item : items) {
                if (item != null) {
                    System.out.println(item.printLabel());
                }
            }
        }
    }
}