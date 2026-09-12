
package main.java.day5_livecoding.assignment_problems;

public class ReferenceDeskAccess {

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
        
        if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
            if ("protected".equals(fieldModifier) || "public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        
        if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) {
            if ("public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        
        return "DENIED";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result = classifyAccess(modifier, context);
            
            if ("DENIED".equals(result)) {
                return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] attempts1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(attempts1));

        String[][] attempts2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(attempts2));
    }
}