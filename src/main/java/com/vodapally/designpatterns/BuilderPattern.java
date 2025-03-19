package com.vodapally.designpatterns;

import lombok.ToString;

@ToString
class Car {
    private String engine;
    private int wheels;
    private String colour;

    // private constructor to enforce use of the CarBuilder
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.colour = builder.colour;
    }

    public static class CarBuilder {
        private String engine;
        private int wheels;
        private String colour;

        // Builder methods for each field
        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        // build method to create the Car object
        public Car build() {
            return new Car(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setEngine("Bharath Stage IV")
                .setWheels(4)
                .setColour("Blue")
                .build();

        System.out.println("car -> " + car);
    }
}
/*
The Builder pattern is a creational design pattern that allows for the step-by-step construction of complex objects.
It separates the construction of a complex object from its representation,
enabling the same construction process to create various representations.
 */