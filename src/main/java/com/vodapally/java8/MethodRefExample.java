package com.vodapally.java8;

import java.util.function.Function;
import java.util.function.Predicate;

class EvenOddCheck{
	
	private String name;
	
	EvenOddCheck(){}
	
	EvenOddCheck(String name){
		this.name=name;
	}
	
	//static method
	public static boolean isEven(Integer n) {
		return n%2 == 0;
	}
	
	//concrete method
	public boolean isOdd(Integer n) {
		return n%2!=0;
	}

	public String getName() {
		return name;
	}

}

public class MethodRefExample {

	public static void main(String[] args) {
		
		/**** Using Lambda Expression ****/
        System.out.println("--------------------Using Lambda Expression----------------------");
        Predicate<Integer> predicate = (n) -> EvenOddCheck.isEven(n);
        System.out.println("Is 20 even number? "+predicate.test(20));
        
        
        /**** Using Method Reference -- Call static method ****/
        System.out.println("\n------------Using Method Reference - Call static method---------------------");
        Predicate<Integer> predicate2= EvenOddCheck::isEven;
        System.out.println("Is 25 even number? "+predicate2.test(25));

        
        System.out.println("\n------------Using Method Reference - Call instance method---------------------");
        EvenOddCheck evenOddCheck = new EvenOddCheck();
        Predicate<Integer> oddPredicate = evenOddCheck::isOdd;
        System.out.println("Is 7 odd number? "+oddPredicate.test(7));
        
        System.out.println("\n------------Using Method Reference - Call instance method---------------------");
        
        //COnstructor reference
        Function<String,EvenOddCheck> fn = EvenOddCheck::new;
        System.out.println(fn.apply("Hello Raghu..").getName());
        
	}

}
