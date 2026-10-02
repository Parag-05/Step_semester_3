package main.java.week8.assignment_problems;

abstract class MembershipPlan {
    private String planType;
    private double monthlyFee;

    public MembershipPlan(String planType, double monthlyFee) {
        this.planType = planType;
        this.monthlyFee = monthlyFee;
    }

    public String getPlanType() { return planType; }
    public double getMonthlyFee() { return monthlyFee; }

    public abstract double calculateTotalFee(int months);
}

class BasicPlan extends MembershipPlan {
    public BasicPlan() {
        super("Basic", 30.0);
    }

    @Override
    public double calculateTotalFee(int months) {
        return getMonthlyFee() * months;
    }
}

class PremiumPlan extends MembershipPlan {
    public PremiumPlan() {
        super("Premium", 50.0);
    }

    @Override
    public double calculateTotalFee(int months) {
        return getMonthlyFee() * months;
    }
}

class VipPlan extends MembershipPlan {
    public VipPlan() {
        super("VIP", 80.0);
    }

    @Override
    public double calculateTotalFee(int months) {
        return getMonthlyFee() * months;
    }
}

class Member {
    private String id;
    private String name;
    private MembershipPlan plan;

    public Member(String id, String name, MembershipPlan plan) {
        this.id = id;
        this.name = name;
        this.plan = plan;
    }

    public String getName() { return name; }
    public MembershipPlan getPlan() { return plan; }

    public void registerMembership(int months) {
        double total = plan.calculateTotalFee(months);
        System.out.printf("Membership registered for %s (%s Plan, %d months). Total Fee: $%.2f.\n",
                name, plan.getPlanType(), months, total);
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member m1 = new Member("M001", "Rohan", new BasicPlan());
        Member m2 = new Member("M002", "Sanya", new PremiumPlan());
        Member m3 = new Member("M003", "Vikram", new VipPlan());

        m1.registerMembership(3);
        m2.registerMembership(6);
        m3.registerMembership(12);
    }
}