package main.java.week7.assignment_problems;

public class Tablet extends ClassroomDevice implements Chargeable {
    private String assetTag;

    public Tablet(String assetTag) {
        if (assetTag == null || assetTag.trim().isEmpty()) {
            throw new IllegalArgumentException("Asset tag cannot be blank.");
        }
        this.assetTag = assetTag;
    }

    @Override
    public String operate() {
        return "Tablet " + assetTag + " displaying lesson";
    }

    @Override
    public String charge() {
        return assetTag + " charging";
    }

    @Override
    public String charge(int minutes) {
        return assetTag + " charging for " + minutes + " minutes";
    }
}