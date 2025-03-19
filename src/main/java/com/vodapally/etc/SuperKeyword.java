package com.vodapally.etc;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called. Name: " + name);
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
        System.out.println("Dog constructor called. Breed: " + breed);
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        Dog dog = new Dog("Puppy", "Husky");
    }
}
