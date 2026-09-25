package main.java.library.class_problems;

import java.util.Arrays;

public class LibraryMember {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;
    
    // Problem 5 fields: Unique final memberNumber and static counter
    private static int counter = 100;
    public final String memberNumber;

    // Fine ledger fields (Problem 3)
    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    // --- QUESTION 1 & PROBLEM 5 CONSTRUCTOR ---
    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: must be at least 4 characters and non-blank.");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        // Assign unique final memberNumber from static counter[cite: 3]
        this.memberNumber = "LIB-" + (++counter);
    }

    // Overloaded constructor for Problem 5 (taking only borrowLimit)[cite: 3]
    public LibraryMember(int borrowLimit) {
        this.memberId = "LIB-DEF";
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        this.memberNumber = "LIB-" + (++counter);
    }

    // --- METHODS & OVERLOADED borrowBook (Problem 5) ---
    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    // Overloaded borrowBook with genre, reusing no-arg version internally[cite: 3]
    public void borrowBook(String genre) {
        borrowBook();
        // Genre handling can be recorded or logged if needed
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberId() {
        return memberId;
    }

    public void displayInfo() {
        System.out.print("General | Books: " + booksBorrowed);
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolledCount = 0;
        int rejectedCount = 0;

        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new LibraryMember(id, borrowLimit);
                    enrolledCount++;
                } catch (IllegalArgumentException e) {
                    rejectedCount++;
                }
            }
        }
        return "Enrolled: " + enrolledCount + " | Rejected: " + rejectedCount;
    }

    // --- PROBLEM 5 UTILITY METHODS ---
    public static int getMembersEnrolled() {
        return counter - 100;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        // Format: 'R' + two digits + one uppercase letter[cite: 3]
        return code.charAt(0) == 'R' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processedCount = 0;
        int nullCount = 0;
        int facultyCount = 0;
        int regularCount = 0;

        if (members != null) {
            for (LibraryMember member : members) {
                if (member == null) {
                    nullCount++;
                } else {
                    processedCount++;
                    // Use instanceof to separate FacultyMember from regular LibraryMember[cite: 3]
                    if (member instanceof FacultyMember) {
                        facultyCount++;
                    } else {
                        regularCount++;
                    }
                }
            }
        }
        return processedCount + " processed | " + nullCount + " null skipped | " + facultyCount + " faculty " + regularCount + " regular";
    }

    // --- PROBLEM 3 FINE LEDGER METHODS ---
    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }

    // --- PROBLEM 4: WEEKLY CIRCULATION REPORT ---
    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (LibraryMember member : members) {
                if (member != null) {
                    sb.append("General | Books: ").append(member.getBooksBorrowed());
                    
                    if (member instanceof StudentMember) {
                        StudentMember student = (StudentMember) member;
                        sb.append(" | Student | Course: ").append(student.getCourse())
                          .append(" [Course via downcast: ").append(student.getCourse()).append("]");
                    }
                    sb.append(" | ");
                }
            }
        }
        return sb.toString();
    }
}