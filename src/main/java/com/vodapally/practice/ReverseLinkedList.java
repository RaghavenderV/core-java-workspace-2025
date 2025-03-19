package com.vodapally.practice;

class ReverseLinkedList { 

	static Node head; 

	static class Node { 
		int data; 
		Node next; 
		
		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	public Node reverse(Node node) 
	{ 
		Node prev = null; 
		Node current = node; 
		Node next = null; 
		while (current != null) { 
			next = current.next; 
			current.next = prev; 
			prev = current; 
			current = next; 
		} 
		node = prev; 
		return node; 
	} 

	// prints content of double linked list 
	void printList(Node node) 
	{ 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
	} 

	public static void main(String[] args) { 
		ReverseLinkedList list = new ReverseLinkedList(); 
		list.head = new Node(99); 
		list.head.next = new Node(55); 
		list.head.next.next = new Node(1); 
		list.head.next.next.next = new Node(80); 

		System.out.println("Given Linked list"); 
		list.printList(head); 
		head = list.reverse(head); 
		System.out.println(""); 
		System.out.println("Reversed linked list "); 
		list.printList(head); 
	} 
} 
