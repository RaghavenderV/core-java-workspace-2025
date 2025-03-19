package com.abhi.generics;

class BankAccount<T extends Number>{// this class accepts Number class and its sub-classes
    public void display(T[] t){
        for (T i : t){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
public class BoundedGenerics {
    public static void main(String[] args) {
        BankAccount<Number> b1 = new BankAccount<>();
        Integer[] i1 = {101, 201, 301};
        Double[] d1 = {500.23, 365.23, 698.32};

        b1.display(i1);
        b1.display(d1);
    }
}
