package com.vodapally.collections;

import java.util.Arrays;

/**
 * 
 * @author RAGHAVENDER
 * This class provides custom implementation of ArrayList without using java API's
 * 
 */

public class ArrayListCustom<E>{
	private static final int INITIAL_CAPACITY = 10;
	private Object elementData[] = {};
	private int size = 0;

	public ArrayListCustom(){
		elementData = new Object[INITIAL_CAPACITY];
	}
	
	/**
	 * method adds elements in ArrayListCustom
	 */
	public void add(E e){
		if(size == elementData.length){
			ensureCapacity(); // increase current capacity of list, make it double
		}
		
		elementData[size++] = e;
	}
	
	/**
	 * method returns element on specific index
	 */
	public E get(int index){
		if(index<0 || index>=size){ // if index is negative or greater than size, then throw Exception
			throw new IndexOutOfBoundsException("Index: "+index + "Size: "+ index);
		}
		
		return (E)elementData[index]; // return value for that index
	}
	
	/**
	 * method returns removedElement on specific index
	 */
	public Object remove(int index){
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException("Index: "+index + "Size: "+ index);
		}
		
		Object removedElement = elementData[index];
		
		for(int i = index; i<size; i++){
			elementData[i] = elementData[i+1];
		}
		
		size--;
		
		return removedElement;
	}
	
	/**
	 * method increases the capacity of list by making it double
	 */
	private void ensureCapacity(){
		int newIncreasedCapacity = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	}
	
	public void display(){
		System.out.println("Displaying list: ");
		for(int i=0; i<size; i++){
			System.out.println(elementData[i] + "  ");
		}
	}
	
	// main class
	public static void main(String[] args) {
		ArrayListCustom<Integer> list = new ArrayListCustom<Integer>();
		list.add(1);
		list.add(3);
		list.add(1);
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(2);
		
		list.display();
		
		System.out.println("\nelement at index " + 1 + " = " + list.get(1));
		System.out.println("\nelement removed from index " + 1 + " = " + list.remove(1));
		
		System.out.println("\nlet's display list again after removal at index 1");
		list.display();
	}

}
