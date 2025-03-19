package com.vodapally.practice;


import static java.lang.System.exit;

class StackUsingLinkedlist {

	private class Node {

		int data; 
		Node link; 
	}

	Node top;

	StackUsingLinkedlist() {
		this.top = null;
	}

	@SuppressWarnings("unused")
	public void push(int x)
	{
		Node temp = new Node();

		if (temp == null) {
			System.out.print("\nHeap Overflow");
			return;
		}

		temp.data = x;
		temp.link = top;
		top = temp;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public void pop() 
	{
		// check for stack underflow
		if (top == null) {
			System.out.print("\nStack Underflow");
			return;
		}

		// update the top pointer to point to the next node
		top = (top).link;
	}

	public void display() {
		// check for stack underflow
		if (top == null) {
			System.out.printf("\nStack Underflow");
			exit(1);
		} else {
			Node temp = top;
			while (temp != null) {

				System.out.printf("%d->", temp.data);

				temp = temp.link;
			}
		}
	}
}

public class MyStackUsingLinkedList {

	public static void main(String[] args) {
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		// insert Stack value
		obj.push(56);
		obj.push(45);
		obj.push(98);
		obj.push(10);

		obj.display();

		System.out.printf("\nTop element is %d\n", obj.peek());

		// Delete top element of Stack
		System.out.println("Calling pop() twice..");
		obj.pop();
		obj.pop();

		// print Stack elements
		obj.display();

		// print Top element of Stack
		System.out.println("\nTop element is \n"+ obj.peek());

	}

}
