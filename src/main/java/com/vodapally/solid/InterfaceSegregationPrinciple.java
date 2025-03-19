package com.vodapally.solid;

// Segregated interfaces
interface Workable{
    void work();
}

interface Eatable{
    void eat();
}
class Human implements Workable, Eatable{

    @Override
    public void eat() {
        System.out.println("Raghu eating...");
    }

    @Override
    public void work() {
        System.out.println("Raghu working...");
    }
}
class Robot implements Workable{

    @Override
    public void work() {
        System.out.println("Robot working");
    }
}
public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        Human human = new Human();
        human.eat();
        human.work();

        Robot robot = new Robot();
        robot.work();
    }
}

/*
Interface Segregation Principle (ISP)
Definition: Clients should not be forced to depend on interfaces they don’t use.

Explanation: Keep interfaces small and specific,
so implementing classes don’t have to provide unnecessary methods.

BAD Design Example
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work()
    public void eat() {
}
 */
