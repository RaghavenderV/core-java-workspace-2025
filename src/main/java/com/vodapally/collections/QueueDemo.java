package com.abhi.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* Author@ Raghavender Vodapally
* Date@ Sep 5, 2017
*/
public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> q = new PriorityQueue<>(); //Does not allow null objects
		q.add(123);
		q.add(256);
		q.add(null);
		System.out.println(q);

	}

}

