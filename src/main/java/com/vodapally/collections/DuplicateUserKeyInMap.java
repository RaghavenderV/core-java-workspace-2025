package com.vodapally.collections;

import java.util.HashMap;
import java.util.Set;

/*
 * Author@ Raghavender Vodapally
 * Date@ Jul 23, 2017
 */

class Price{
	private String item;
	private int price;
	
	//override equals and hashcode for object comparison
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Price){
			Price p = (Price)obj;
			return((p.item.equals(this.item)) && (p.price == this.price));
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return price*22;
	}
	
	public Price(String item, int price) {
		this.item = item;
		this.price = price;
	}
	//setters and getters
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "item:"+item+" price:"+price;
	}
}

public class DuplicateUserKeyInMap {

	public static void main(String[] args) {
		HashMap<Price, String> itemsMap = new HashMap<>();
		itemsMap.put(new Price("Banana", 40), "BANANA");
		itemsMap.put(new Price("Apple", 85), "APPLE");
		itemsMap.put(new Price("Guava", 90), "GUAVA");
		
		printItemsMap(itemsMap);
		
		Price dupKey = new Price("Banana", 40);
		System.out.println("\nAdding duplicate key in map");
		itemsMap.put(dupKey, "Duplicate key added");
		
		System.out.println("\nAfter Adding duplicate key");
		printItemsMap(itemsMap);

	}

	private static void printItemsMap(HashMap<Price, String> itemsMap) {
		Set<Price> keys = itemsMap.keySet();
		for(Price price: keys){
			System.out.println(price + " : "+itemsMap.get(price));
		}
		
	}

}

