package com.vodapally.solid;

interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 6);
        System.out.println("Area of a rectangle: 5*6 = " + rectangle.getArea());

        Square square = new Square(9);
        System.out.println("Area of a square: 9*9 = " + square.getArea());
    }
}
/*
L - Liskov Substitution Principle (LSP)
Definition: Subtypes must be substitutable for their base types without altering the correctness of the program.
Explanation: If a subclass overrides a method in a way that breaks the expected behavior of the base class, it violates LSP.

Bad: Rectangle and Square violate LSP
class Rectangle {
    int width, height;
    void setWidth(int w) { width = w; }
    void setHeight(int h) { height = h; }
    int getArea() { return width * height; }
}
class Square extends Rectangle {
    @Override
    void setWidth(int w) { width = height = w; }
    @Override
    void setHeight(int h) { height = width = h; }
}
 */