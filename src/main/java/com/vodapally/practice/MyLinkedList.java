package com.vodapally.practice;

class Node{
	int data;
	Node next;
}

// methods similar to Linked List
class LinkedListOps{
	Node head;
	
	// it will insert data at the end of the linked list
	public void insert(int data) {
		//create an empty new node
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		//check inserted node is first node, then it is head node
		if(head == null) {
			head = node;
		}
		//means there exists some nodes in linked list.
		//traverse till last node to insert your node 
		else {
			Node n = head;
			while(n.next!=null) {
				n = n.next; //move to the next node if node is not null
			}
			n.next = node; // assign the new node to last node
		}
		
	}
	
	
	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		//make current node as head node
		head = node;
		
	}
	
	//insert element at the specified location
	public void insertAt(int index, int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		Node n = head;
		if(index==0) {
			insertAtStart(data);
		}
		for(int i=0;i<index-1;i++) {
			n= n.next;
		}
		node.next = n.next;
		n.next = node;
	}
	
	//it will display all the nodes in the Linked List
	public void show() {
		Node node = head;
		while(node.next!= null) {
			System.out.print(node.data+"->");
			node = node.next;
		}
		System.out.println(node.data+"->"+node.next);
		
	}
	
	public int size() {
		int counter=0;
		Node node = head;
		while(node.next!=null) {
			counter++;
			node = node.next;
		}
		
		return ++counter;
	}
	
	public void deleteAt(int index) {
		if(index == 0) {
			head = head.next;
		}else {
		Node n = head;
		for(int i=0; i<index-1; i++) {
			n=n.next;
		}
		n.next = n.next.next;
		}
	}
	
	public void printMiddle() {
		Node slowPtr = head;
		Node fastPtr = head;
		
		if(head!=null) {
			while(fastPtr!=null && fastPtr.next!=null) {
				fastPtr=fastPtr.next.next;
				slowPtr=slowPtr.next;
			}
			System.out.println("\nThe middle element is : "+slowPtr.data);
			
		}
	}
	
	/*
	 * public Node reverse(Node node) { Node prev=null; Node current = node; Node
	 * next=null;
	 * 
	 * while(current.next!=null) { next=current.next; current.next=prev; prev =
	 * current; current= next; } node=prev; return node; }
	 */
}
public class MyLinkedList {

	public static void main(String[] args) {
		
		LinkedListOps list = new LinkedListOps();
		list.insert(99);
		list.insert(68);
		list.insert(44);
		list.insert(58);
		list.insert(55);
		list.insert(89);
		System.out.println("Original List: ");
		list.show();
		
		list.printMiddle();
		
		System.out.println("\nInsert 100 at start of the List");
		list.insertAtStart(100);
		list.show();
		
		System.out.println("\nInsert 1 at 3rd index position");
		list.insertAt(3, 1);
		list.show();
		
		System.out.println("\nDelete element at 3rd index : i.e. element 1");
		list.deleteAt(3);
		list.show();
		
		int size = list.size();
		System.out.println("Size of the Linked List: "+size);
	}

}
