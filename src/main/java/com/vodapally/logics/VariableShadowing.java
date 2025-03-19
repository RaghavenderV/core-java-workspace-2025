package com.vodapally.logics;

public class VariableShadowing {

    static int x = 10;
    int y = 20;

    void test(int x, int y) {
        // accessing hidden static variable using class name
        System.out.println("x = " + VariableShadowing.x); //10;  also can be accessed as this.x

        // accessing hidden non-static variable using this keyword
        System.out.println("y = " + this.y); //20

        System.out.println("x:y : " + x + " " + y); // 30 40
    }


    public static void main(String[] args) {
        VariableShadowing obj = new VariableShadowing();
        obj.test(30, 40);

    }

}
