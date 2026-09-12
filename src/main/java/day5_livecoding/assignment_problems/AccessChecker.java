package main.java.day5_livecoding.assignment_problems;

class LibraryMember {
    @SuppressWarnings("unused")
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}

public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SAME_CLASS".equals(accessorContext)) {
            return "ALLOWED";
        }
        
        if ("SAME_PACKAGE".equals(accessorContext)) {
            if ("private".equals(fieldModifier)) {
                return "DENIED";
            }
            return "ALLOWED";
        }
        
        if ("DIFFERENT_PACKAGE".equals(accessorContext)) {
            if ("public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;

        for (String[] attempt : attempts) {
            String modifier = attempt[0];
            String context = attempt[1];
            String result = classifyAccess(modifier, context);
            boolean isAllowed = "ALLOWED".equals(result);

            switch (modifier) {
                case "private":
                    if (isAllowed) privateAllowed++; else privateDenied++;
                    break;
                case "default":
                    if (isAllowed) defaultAllowed++; else defaultDenied++;
                    break;
                case "protected":
                    if (isAllowed) protectedAllowed++; else protectedDenied++;
                    break;
                case "public":
                    if (isAllowed) publicAllowed++; else publicDenied++;
                    break;
            }
        }

        return "private: " + privateAllowed + " allowed / " + privateDenied + " denied\n" +
               "default: " + defaultAllowed + " allowed / " + defaultDenied + " denied\n" +
               "protected: " + protectedAllowed + " allowed / " + protectedDenied + " denied\n" +
               "public: " + publicAllowed + " allowed / " + publicDenied + " denied";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(attempts));
    }
}
