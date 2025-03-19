package com.vodapally.logics;

import java.util.Objects;

class Money {
    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    @Override
    public boolean equals(Object obj) {
        // check if both the obj references are referring to the same object
        if (this == obj)
            return true;
        // check if both objects are null or different objects-> return false
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        // type casting to Money
        Money money = (Money) obj;
        // compare the state of the object with the state of 'this' object
        return (money.amount == this.amount && money.currencyCode.equals(this.currencyCode));

    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currencyCode); // Objects utility provided in java 7
    }
}

public class EqualsAndHashCode {

    public static void main(String[] args) {

        Money income = new Money(60, "INR");
        Money expenses = new Money(60, "INR");

        if (income.equals(expenses)) {
            System.out.println("income and expenses objects are EQUAL");
        } else {
            System.out.println("income and expenses objects are NOT EQUAL");
        }
        System.out.println("income hashCode : " + income.hashCode());
        System.out.println("income hashCode : " + expenses.hashCode());
    }
}



