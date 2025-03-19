package com.abhi.collections;

import java.util.ArrayDeque;

public class ArrayDequeDemo {

	public static void main(String[] args) {
		ArrayDeque<String> queue = new ArrayDeque<>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue.poll()); //FIFO - acts as queue - one
        System.out.println(queue.pop());//LIFO - acts as Stack - four


	}

}

/* ArrayDeque is a resizable-array implementation of Deque interface like ArrayList class which is a resizable-array 
 * implementation of List interface. But, ArrayDeque is not a List
*/

/*ArrayDeque can be used as a stack (LIFO) as well as a queue (FIFO). 
 * ArrayDeque is faster than the Stack class when used as a stack and faster than the LinkedList class 
 * when used as a queue. */
