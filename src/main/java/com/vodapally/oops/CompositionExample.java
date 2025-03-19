package com.vodapally.oops;

class Room {
    private String type;

    public Room(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class House {
    private String address;
    private Room room; // Composition: House "owns" Room

    public House(String address, String roomType) {
        this.address = address;
        this.room = new Room(roomType); // Room is created within House
    }

    public void display() {
        System.out.println("House at " + address + " has a " + room.getType() + " room");
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        House house = new House("Kukatpally", "Living");
        house.display();

        // If house is destroyed (set to null), the room is also destroyed
        house = null;
        // No way to access the room independently
        //house.display(); // NullPointerException
    }
}

/*
Composition
Definition: Composition is a "strong" has-a relationship where one class owns another class, and the contained object cannot exist without the container. It implies a stricter "part-of" relationship with full ownership.
Lifecycle: The contained object’s lifecycle is tied to the container. If the container is destroyed, the contained object is destroyed too.
Example: A House and Room relationship. A room is part of a house, and if the house is demolished, the room no longer exists.

Key Point: The Room object is created inside the House class, showing that Room is fully dependent on House.
 */