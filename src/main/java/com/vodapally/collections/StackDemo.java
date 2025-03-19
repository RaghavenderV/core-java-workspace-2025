package com.vodapally.collections;

import java.util.Stack;

/*
* Author@ Raghavender Vodapally
* Date@ Sep 2, 2017
*/
public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(new Integer(10));
		stack.push(new Integer(20));
		stack.push(new Integer(30));
		
		Integer popped = stack.pop();
		System.out.println("Popped element: "+popped);//LIFO -> 30
		
		
		stack.push(new Integer(40));
		System.out.println(stack); //10 20 40

	}

}

/*
Java provides an inbuilt object type called Stack. It is a collection that is based on the last in first out (LIFO) 
principle. On Creation, a stack is empty.
 
*/