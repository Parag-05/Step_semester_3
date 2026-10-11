package main.java.week10.class_problems;

import java.util.ArrayList;
import java.util.List;

class StudentRecord {
    String name;
    int[] marks;

    public StudentRecord(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getTotal() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }
}

public class ClassMarksGridAnalysis {

    public static void main(String[] args) {
        List<StudentRecord> students = new ArrayList<>();
        students.add(new StudentRecord("Asha", new int[]{78, 85, 90}));
        students.add(new StudentRecord("Ravi", new int[]{88, 92, 79}));
        students.add(new StudentRecord("Neha", new int[]{65, 70, 95}));

        int numStudents = students.size();
        int numSubjects = 3;

        // 1. Calculate student totals and find topper
        StringBuilder totalsSB = new StringBuilder("Totals ");
        String topperName = "";
        int maxTotal = -1;

        for (int i = 0; i < numStudents; i++) {
            StudentRecord s = students.get(i);
            int total = s.getTotal();

            totalsSB.append(s.name).append(" ").append(total);
            if (i < numStudents - 1) {
                totalsSB.append(", ");
            }

            if (total > maxTotal) {
                maxTotal = total;
                topperName = s.name;
            }
        }
        System.out.println(totalsSB.toString());

        // 2. Calculate subject averages
        double[] subjectSums = new double[numSubjects];
        for (StudentRecord s : students) {
            for (int j = 0; j < numSubjects; j++) {
                subjectSums[j] += s.marks[j];
            }
        }

        StringBuilder avgSB = new StringBuilder("averages ");
        for (int j = 0; j < numSubjects; j++) {
            double avg = subjectSums[j] / numStudents;
            avgSB.append(String.format("%.2f", avg));
            if (j < numSubjects - 1) {
                avgSB.append(", ");
            }
        }
        System.out.println(avgSB.toString());

        // 3. Print topper
        System.out.printf("topper %s (%d)\n", topperName, maxTotal);
    }
}
