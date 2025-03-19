package com.vodapally.practice;

class Stack {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];

	Stack() {
		top = -1;
	}
	
	boolean isEmpty() {
		return (top < 0);
	}

	boolean push(int x) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = x;
			System.out.println(x + " pushed into stack");
			return true;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}
}

public class MyStack {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(99);
		s.push(66);
		s.push(55);
		s.push(87);
		System.out.println("-------------------------");
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("-------------------------");
		System.out.println("Peak element : " + s.peek());

	}

}
