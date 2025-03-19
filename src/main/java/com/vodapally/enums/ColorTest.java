package com.abhi.enums;

enum Color {
    RED, GREEN, BLUE; // impliciltly public static final

    Color() { // by default private
        System.out.println("Constructor called for -> " + this.toString());
    }//calls for every enum constant by default

    public void colorInfo(){
        System.out.println("Universal color");
    }
}

public class ColorTest {
    public static void main(String[] args) {
        Color c1 = Color.RED;
        System.out.println("\n c1 = " + c1);
        c1.colorInfo();

        // Enums have built-in methods like values(), valueOf(), ordinal()
        for(Color color: Color.values()){
            System.out.println(color + " at index : "+color.ordinal());

        }

        System.out.println("\n"+Color.valueOf("RED"));
    }
}
