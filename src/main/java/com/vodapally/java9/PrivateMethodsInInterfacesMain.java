package com.vodapally.java9;

interface PrivateMethodsInInterfaces {
    default void defaultMethod1() {
        commonMethod();
    }

    default void defaultMethod2() {
        commonMethod();
    }

    private void commonMethod() {
        System.out.println("private commonMethod() in interface");
    }
}

public class PrivateMethodsInInterfacesMain implements PrivateMethodsInInterfaces{
    public static void main(String[] args) {
        PrivateMethodsInInterfaces obj = new PrivateMethodsInInterfacesMain();
        obj.defaultMethod1();
    }
}
