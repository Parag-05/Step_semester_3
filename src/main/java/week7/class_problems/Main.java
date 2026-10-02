package main.java.week7.class_problems;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Talking Toy Box ===");
        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");
        System.out.println(car.makeSound());
        System.out.println(robot.makeSound());
        System.out.println(car.getToyId());
        System.out.println(robot.getToyId());

        System.out.println("\n=== Problem 2: Warehouse Label Printer ===");
        PackageBox p = new PackageBox("TRK-88");
        Invoice i = new Invoice("INV-42");
        System.out.println(p.printLabel());
        System.out.println(i.printLabel());
        Printable.printAll(new Printable[]{ p, i });

        System.out.println("\n=== Problem 3: Orchestra Warm-Up Routine ===");
        StringInstrument s = new StringInstrument();
        System.out.println(s.play());
        Violin v = new Violin();
        System.out.println(v.play());

        System.out.println("\n=== Problem 4: Smart Kitchen Assistant ===");
        Blender b = new Blender();
        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel());
        b.setSpeedLevel(9);
        System.out.println(b.getSpeedLevel());
        System.out.println(b.prepare());
        System.out.println(b.clean());

        System.out.println("\n=== Problem 5: Package Drop-Off Log ===");
        ParcelNote pn = new ParcelNote("TRK-1");
        System.out.println(pn.confirmDelivery());
        System.out.println(pn.confirmDelivery("J. Smith"));
        DeliveryNote.logAll(new DeliveryNote[]{ pn, new LetterNote("TRK-2") });
    }
}