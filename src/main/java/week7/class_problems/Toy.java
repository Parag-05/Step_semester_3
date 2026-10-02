package main.java.week7.class_problems;

public abstract class Toy {
    private static int counter = 1001;
    private final String toyId;
    protected String name;

    public Toy(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        this.name = name;
        this.toyId = "TOY-" + counter++;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}