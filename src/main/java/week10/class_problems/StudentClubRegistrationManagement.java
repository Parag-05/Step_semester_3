package main.java.week10.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private String rollNumber;
    private String name;

    public Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    // Uniqueness is strictly based on roll number
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rollNumber, student.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}

public class StudentClubRegistrationManagement {

    public static void main(String[] args) {
        Set<Student> members = new HashSet<>();

        String[][] operations = {
            {"ADD", "21CS01", "Asha"},
            {"ADD", "21CS01", "Asha"},
            {"ADD", "21CS02", "Ravi"},
            {"CONTAINS", "21CS02", "Ravi"},
            {"CONTAINS", "21CS03", "Priya"}
        };

        boolean memberCountPrinted = false;

        for (String[] op : operations) {
            String command = op[0];
            String roll = op[1];
            String name = op[2];
            Student student = new Student(roll, name);

            if (command.equals("ADD")) {
                if (members.add(student)) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }
            } else if (command.equals("CONTAINS")) {
                if (!memberCountPrinted) {
                    System.out.println("member count " + members.size());
                    memberCountPrinted = true;
                }
                System.out.println("contains: " + members.contains(student));
            }
        }
    }
}