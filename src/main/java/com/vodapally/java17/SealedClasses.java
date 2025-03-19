package com.vodapally.java17;

sealed interface Service permits Car, Truck {
    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKMs() {
        return 100000;
    }
}

abstract sealed class Vehicle permits Car, Truck {
    protected final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

final class Truck extends Vehicle implements Service {
    private int loadCapacity;

    public Truck(String registrationNumber, int loadCapacity) {
        super(registrationNumber);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }


    @Override
    public int getMaxServiceIntervalInMonths() {
        return 18;
    }
}

non-sealed class Car extends Vehicle implements Service {
    private final int numberOfSeats;

    public Car(String registrationNumber, int numberOfSeats) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


    @Override
    public int getMaxServiceIntervalInMonths() {
        return 24;
    }
}

public class SealedClasses {
    public static void main(String[] args) {
        Truck truck = new Truck("TS35A9989", 15);
        int loadCapacity = truck.getLoadCapacity();
        int maxServiceIntervalInMonths = truck.getMaxServiceIntervalInMonths();
        String truckRegistrationNumber = truck.getRegistrationNumber();
        System.out.println("Truck loadCapacity = " + loadCapacity);
        System.out.println("Truck maxServiceIntervalInMonths = " + maxServiceIntervalInMonths);
        System.out.println("truckRegistrationNumber = " + truckRegistrationNumber);


        Car car = new Car("TS36P5698", 7);
        int carMaxServiceIntervalInMonths = car.getMaxServiceIntervalInMonths();
        int numberOfSeats = car.getNumberOfSeats();
        String carRegistrationNumber = car.getRegistrationNumber();
        System.out.println("\nCar numberOfSeats = " + numberOfSeats);
        System.out.println("carMaxServiceIntervalInMonths = " + carMaxServiceIntervalInMonths);
        System.out.println("carRegistrationNumber = " + carRegistrationNumber);


    }
}

/*
Sealed classes allow us to restrict which classes can extend or implement them.

A sealed class imposes three important constraints on its permitted subclasses:
All permitted subclasses must belong to the same module as the sealed class.
Every permitted subclass must explicitly extend the sealed class.
Every permitted subclass must define a modifier: final, sealed, or non-sealed.
 */
