package com.vodapally.solid;

// Good: Open for extension via interface
interface Shape1{
    double calculateArea();
}
class Circle1 implements Shape1{
    private double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}

class Square1 implements Shape1{
    private double side;

    public Square1(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side*side;
    }
}
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Circle1 circle = new Circle1(5);
        System.out.println("Area of a circle: "+circle.calculateArea());

        Square1 square = new Square1(8);
        System.out.println("Area of a square: "+square.calculateArea());
    }
}
/*
Definition: Classes should be open for extension but closed for modification.

Explanation: You should be able to add new functionality (extend) without changing existing code.
This is often achieved using interfaces or abstract classes.

Bad: Modifying class for new shapes
class AreaCalculator {
    double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return Math.PI * c.radius * c.radius;
        } else if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        }
        return 0;
    }
}
 */