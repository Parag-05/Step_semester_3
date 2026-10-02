package main.java.week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;

abstract class FileType {
    private String extension;

    public FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() { return extension; }
    public abstract boolean isValidFormat(String fileName);
}

class PdfFile extends FileType {
    public PdfFile() {
        super("pdf");
    }

    @Override
    public boolean isValidFormat(String fileName) {
        return fileName.toLowerCase().endsWith(".pdf");
    }
}

class ZipFile extends FileType {
    public ZipFile() {
        super("zip");
    }

    @Override
    public boolean isValidFormat(String fileName) {
        return fileName.toLowerCase().endsWith(".zip");
    }
}

class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

class AssignmentPortal {
    private String course;
    private FileType allowedType;
    private boolean open;
    private List<String> submittedStudentIds = new ArrayList<>();

    public AssignmentPortal(String course, FileType allowedType) {
        this.course = course;
        this.allowedType = allowedType;
        this.open = true;
    }

    public void submitAssignment(Student student, String fileName) {
        if (!open) {
            System.out.println("Submission portal for " + course + " is closed.");
            return;
        }
        if (submittedStudentIds.contains(student.getId())) {
            System.out.println(student.getName() + " has already submitted the assignment.");
            return;
        }
        if (!allowedType.isValidFormat(fileName)) {
            System.out.println("Invalid file format for " + student.getName() + ". Allowed extension: ." + allowedType.getExtension() + ".");
            return;
        }

        submittedStudentIds.add(student.getId());
        System.out.println("Assignment submitted successfully by " + student.getName() + " (" + fileName + ").");
    }

    public void closePortal() {
        this.open = false;
        System.out.println("Submission portal for " + course + " closed.");
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student student1 = new Student("S101", "Ananya");
        Student student2 = new Student("S102", "Karan");

        AssignmentPortal portal = new AssignmentPortal("OOP Lab", new PdfFile());

        portal.submitAssignment(student1, "lab8_ananya.pdf");
        portal.submitAssignment(student2, "lab8_karan.docx");
        portal.submitAssignment(student1, "lab8_ananya_v2.pdf");
        portal.closePortal();
        portal.submitAssignment(student2, "lab8_karan.pdf");
    }
}