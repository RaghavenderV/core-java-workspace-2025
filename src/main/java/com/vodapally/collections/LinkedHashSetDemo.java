package com.vodapally.collections;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

	public static void main(String[] args) {

		Set<Customer> lhs = new LinkedHashSet<>();
		
		Customer c1 = new Customer(801, "raghu");
		Customer c2 = new Customer(801, "raghu"); //duplicate
		Customer c3 = new Customer(101, "abhi");
		Customer c4 = new Customer(301, "siri");
		
		lhs.add(c1);
		lhs.add(c2);
		lhs.add(c3);
		lhs.add(c4);
		
		System.out.println("SET Size: "+lhs.size());
		System.out.println("hashCode of c1,c2,c3,c4: "+
				c1.hashCode()+" "+c2.hashCode()+" "+c3.hashCode()+" "+c4.hashCode());
		
		Iterator<Customer> iterator = lhs.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}

class Customer{
	int id;
	String name;
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		//return this.id*5;
		return this.id*5 + this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Customer){
			Customer customer = (Customer)obj;
			return ((this.id == customer.id) && (this.name.equalsIgnoreCase(customer.name)));
		}
		else
			return false;
	}
	
	
	@Override
	public String toString() {
		return name + " : " + id;
	}
	
	
}


