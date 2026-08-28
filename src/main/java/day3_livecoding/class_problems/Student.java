package day3_livecoding.class_problems;

public class Student {
    private String name;
    private double attendance;

    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public void printStudentDetails() {
        System.out.println("Student: " + this.name + " | Attendance: " + this.attendance + "%");
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Anitha", 92.0);

        s1.printStudentDetails();
        s2.printStudentDetails();

        Student.printCollegeInfo();
    }
}