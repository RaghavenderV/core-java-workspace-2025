package com.vodapally.solid;

interface InputDevice{
    void input();
}

class KeyBoard implements InputDevice{
    @Override
    public void input() {
        System.out.println("KeyBoard class called..");
    }
}

class Computer{
    private InputDevice device;
    public Computer(InputDevice inputDevice){ //dependency injection
        this.device =inputDevice;
    }

    public void start(){
        device.input();
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        InputDevice device = new KeyBoard();
        Computer computer = new Computer(device);
        computer.start();
    }
}
/*
D - Dependency Inversion Principle (DIP)
Definition: High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).

Explanation: Use dependency injection or interfaces to decouple classes, making the system more flexible.
https://grok.com/chat/283e1b65-c011-4747-98e0-4a78e39b1702

**************
Below program is BAD design
Direct dependency
class KeyBoard1{
    void type(){
        System.out.println("KeyBoard1..type");
    }
}
class Computer1{
    KeyBoard1 kb = new KeyBoard1(); // tight coupling
    void start(){
        kb.type();
    }
}
public class BadDIP {
    public static void main(String[] args) {
        Computer1 computer= new Computer1();
        computer.start();
    }
}
 */