package main.java.library.assignment_problems;

import java.util.Arrays;

public class GymMember {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;
    private int feesPaid = 0;

    // Problem 5 fields: Unique final membershipNumber and static counter
    private static int counter = 2000;
    public final String membershipNumber;

    // Late-fee ledger fields (Problem 3)
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    // --- CONSTRUCTORS (Problem 1 & Problem 5) ---
    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: must be at least 4 characters and non-blank.");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        this.membershipNumber = "GYM-" + (++counter);
    }

    // Overloaded constructor taking only monthlyFee (Problem 5)
    public GymMember(int monthlyFee) {
        this.memberId = "GYM-DEF";
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        this.membershipNumber = "GYM-" + (++counter);
    }

    // --- METHODS & OVERLOADED payFee (Problem 5) ---
    public void payFee(int amount) {
        if (amount > 0) {
            feesPaid += amount;
        }
    }

    public void payFee(int amount, String mode) {
        payFee(amount); // Reuses the flat-amount version internally
        // Payment mode can be processed or logged here if needed
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void displayInfo() {
        System.out.print("Standard | Sessions: " + sessionsAttended);
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUpCount = 0;
        int rejectedCount = 0;

        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUpCount++;
                } catch (IllegalArgumentException e) {
                    rejectedCount++;
                }
            }
        }
        return "Signed Up: " + signedUpCount + " | Rejected: " + rejectedCount;
    }

    // --- PROBLEM 5 UTILITY METHODS ---
    public static int getMembersEnrolled() {
        return counter - 2000;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        // Format: 'R' + two digits + one uppercase letter (Wait, prompt states "G" + two digits + one uppercase letter, e.g. "G45B")
        return code.charAt(0) == 'G' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processedCount = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (members != null) {
            for (GymMember member : members) {
                if (member == null) {
                    nullCount++;
                } else {
                    processedCount++;
                    // Use instanceof to separate GroupClassMember from regular GymMember
                    if (member instanceof GroupClassMember) {
                        groupCount++;
                    } else {
                        individualCount++;
                    }
                }
            }
        }
        return processedCount + " processed | " + nullCount + " null skipped | " + groupCount + " group " + individualCount + " individual";
    }

    // --- PROBLEM 2 UTILITY METHODS ---
    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof PremiumMember || member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else {
            return "Base class member";
        }
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember member : members) {
                if (member != null) {
                    total += member.getSessionsAttended();
                }
            }
        }
        return total;
    }

    // --- PROBLEM 3 LATE-FEE LEDGER METHODS ---
    protected void chargeLateFee(int amount) {
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }

    // --- PROBLEM 4: MONTHLY ATTENDANCE ANNOUNCER ---
    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members != null) {
            for (GymMember member : members) {
                if (member != null) {
                    sb.append("Standard | Sessions: ").append(member.getSessionsAttended());
                    
                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        sb.append(" | Premium | Trainer: ").append(premium.getTrainerName())
                          .append(" | Sessions: ").append(premium.getSessionsAttended())
                          .append(" [Trainer via downcast: ").append(premium.getTrainerName()).append("]");
                    }
                    sb.append(" | ");
                }
            }
        }
        return sb.toString();
    }
}