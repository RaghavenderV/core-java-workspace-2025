package com.vodapally.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 5, 2017
 */
public class Java8ForEachExample {

	public static void main(String[] args) {
		
		//creating sample collection
		List<Integer> myList = new ArrayList<>();
		
		for(int i=1; i<=10; i++)
		myList.add(i);
		
		//1. traversing using iterator
		Iterator<Integer> it = myList.iterator();
		System.out.println("1. Traversing using iterator");
		while(it.hasNext()){
			System.out.println("Iterator Value: "+it.next());
		}
		
		//2. traversing through forEach method of Iterable with anonymous class
		System.out.println("--------------------------------");
		System.out.println("2. Traversing through forEach method of Iterable with anonymous class");
		myList.forEach(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class value: " + t);
			}
		});
		
		
		System.out.println("--------------------------------");
		System.out.println("3. Traversing with Consumer interface implementation");
		//3. traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		
		
		System.out.println("--------------------------------");
		System.out.println("4. Traversing through lambda and method reference");
		myList.forEach(System.out::println);

	}

}

class MyConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("Consumer impl value: "+t);
		
	}
	
}

//http://www.journaldev.com/2389/java-8-features-with-examples#iterable-forEach

/*Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic 
only. forEach method takes java.util.function.Consumer object as argument, so it helps in having our business logic at a 
separate location that we can reuse.*/ 



