package main.java.week10.class_problems;

import java.util.HashMap;
import java.util.Map;

interface Chargeable {
    String charge();
}

abstract class Vehicle {
    protected String passNumber;
    protected String ownerName;
    protected String type;
    protected int fee;

    public Vehicle(String passNumber, String ownerName, String type, int fee) {
        this.passNumber = passNumber;
        this.ownerName = ownerName;
        this.type = type;
        this.fee = fee;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getType() {
        return type;
    }

    public int getFee() {
        return fee;
    }
}

class Bike extends Vehicle {
    public Bike(String passNumber, String ownerName) {
        super(passNumber, ownerName, "Bike", 300);
    }
}

class Car extends Vehicle {
    public Car(String passNumber, String ownerName) {
        super(passNumber, ownerName, "Car", 1000);
    }
}

class EBike extends Vehicle implements Chargeable {
    public EBike(String passNumber, String ownerName) {
        super(passNumber, ownerName, "EBike", 300);
    }

    @Override
    public String charge() {
        return passNumber + " charging bay allotted";
    }
}

class ECar extends Vehicle implements Chargeable {
    public ECar(String passNumber, String ownerName) {
        super(passNumber, ownerName, "ECar", 1000);
    }

    @Override
    public String charge() {
        return passNumber + " charging bay allotted";
    }
}

public class CampusVehiclePassSystem {

    public static void main(String[] args) {
        Map<String, Vehicle> registry = new HashMap<>();

        // Simulated operation logs
        String[][] operations = {
            {"PASS", "Bike", "KA01", "Asha"},
            {"PASS", "ECar", "KA02", "Ravi"},
            {"CHARGE", "KA02"},
            {"CHARGE", "KA01"}
        };

        for (String[] op : operations) {
            if (op[0].equals("PASS")) {
                String type = op[1];
                String passNo = op[2];
                String owner = op[3];
                Vehicle v = null;

                if (type.equalsIgnoreCase("Bike")) {
                    v = new Bike(passNo, owner);
                } else if (type.equalsIgnoreCase("Car")) {
                    v = new Car(passNo, owner);
                } else if (type.equalsIgnoreCase("EBike")) {
                    v = new EBike(passNo, owner);
                } else if (type.equalsIgnoreCase("ECar")) {
                    v = new ECar(passNo, owner);
                }

                if (v != null) {
                    registry.put(passNo, v);
                    System.out.printf("%s (%s) pass fee %d\n", v.getPassNumber(), v.getType(), v.getFee());
                }
            } else if (op[0].equals("CHARGE")) {
                String passNo = op[1];
                Vehicle v = registry.get(passNo);
                if (v instanceof Chargeable) {
                    System.out.println(((Chargeable) v).charge());
                } else if (v != null) {
                    System.out.printf("%s rejected: charging unsupported\n", passNo);
                } else {
                    System.out.println("Vehicle not found");
                }
            }
        }
    }
}
