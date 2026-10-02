package main.java.week8.assignment_problems;

abstract class WashType {
    private String name;
    private int duration;
    private double charge;

    public WashType(String name, int duration, double charge) {
        this.name = name;
        this.duration = duration;
        this.charge = charge;
    }

    public String getName() { return name; }
    public int getDuration() { return duration; }
    public double getCharge() { return charge; }
}

class QuickWash extends WashType {
    public QuickWash() {
        super("Quick", 30, 20.0);
    }
}

class NormalWash extends WashType {
    public NormalWash() {
        super("Normal", 45, 30.0);
    }
}

class HeavyWash extends WashType {
    public HeavyWash() {
        super("Heavy", 60, 45.0);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

class WashingMachine {
    private String id;
    private boolean busy;

    public WashingMachine(String id) {
        this.id = id;
        this.busy = false;
    }

    public String getId() { return id; }
    public boolean isBusy() { return busy; }

    public void startWash(Student student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + id + " is currently busy.");
            return;
        }
        this.busy = true;
        System.out.printf("%s wash started on %s for %s (%d min). Charge: %.2f.\n",
                washType.getName(), id, student.getName(), washType.getDuration(), washType.getCharge());
    }

    public void completeCycle() {
        this.busy = false;
        System.out.println(id + " cycle completed. " + id + " is now free.");
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}