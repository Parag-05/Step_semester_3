package main.java.week7.assignment_problems;

public class Main {
    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable trackable = (Trackable) o;
            return trackable.getLocation();
        }
        return "Tracking not available";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Morning Wake-Up Circuit ===");
        AlarmClock a = new AlarmClock("7:00 AM");
        Doorbell d = new Doorbell("Front Door");
        System.out.println(a.ring());
        System.out.println(d.ring());
        Ringable.ringAll(new Ringable[]{ a, d });

        System.out.println("\n=== Problem 2: Gallery Description Cards ===");
        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(p.describe());
        System.out.println(s.describe());

        System.out.println("\n=== Problem 3: Backyard Toolshed Routine ===");
        CuttingTool c = new CuttingTool();
        System.out.println(c.use());
        Pruner pr = new Pruner();
        System.out.println(pr.use());

        System.out.println("\n=== Problem 4: Digital Classroom Setup ===");
        Tablet t = new Tablet("TAB-5");
        System.out.println(t.operate());
        System.out.println(t.charge());
        System.out.println(t.charge(30));

        System.out.println("\n=== Problem 5: Skyline Delivery Fleet ===");
        DeliveryDrone dd = new DeliveryDrone("DR-1");
        ScoutDrone sd = new ScoutDrone("SC-1");
        GroundRobot gr = new GroundRobot("GR-1");

        System.out.println(getLocationIfTrackable(dd));
        System.out.println(getLocationIfTrackable(sd));
        System.out.println(getLocationIfTrackable(gr));
    }
}