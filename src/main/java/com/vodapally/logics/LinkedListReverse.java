package com.vodapally.logics;
/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 2, 2017
 */

//http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
public class LinkedListReverse {
	
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	// method to reverse the linked list
	public static Node reverse(Node node){
		Node prev = null;
		Node current = node;
		Node next = null;
		
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	//print contents of double linked list
	public static void printList(Node node){
		while(node!=null){
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.print("NULL");
	}

	public static void main(String[] args) {
		LinkedListReverse list = new LinkedListReverse();
		list.head = new Node(85);
		list.head.next = new Node(10);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(25);
		
		System.out.println("Given Linked List:");
		list.printList(head);
		
		head = list.reverse(head);
		
		System.out.println("\n\nReverse Linked List");
		list.printList(head);
		

	}

}
/*
Input: Head of following linked list
1->2->3->4->NULL
Output: Linked list should be changed to,
4->3->2->1->NULL
*/
