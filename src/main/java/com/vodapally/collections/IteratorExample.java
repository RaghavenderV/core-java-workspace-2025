package com.vodapally.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Author@ Siri-Raghu
 * Date@ 21-Oct-2014
 */
public class IteratorExample {

	public static void main(String[] args) {
		//List<String> myList = new ArrayList<String>();
		
		List<String> myList = new CopyOnWriteArrayList<String>();
				
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
         
        Iterator<String> it = myList.iterator();
        while(it.hasNext()){
            String value = it.next();
            
           // iterator fail-fast property
            if(value.equals("4")) {
            	myList.remove(value);
            	myList.add("6");
            	myList.add("7");
            }
            System.out.println("List Value:"+value);
        }
        
        System.out.println("Now, the updated list is : "+myList);
        System.out.println("\nList Size:"+myList.size());
        System.out.println("\n");
		
		/*
		Since we are updating the existing key value in the myMap, its size has not been changed and 
		we are not getting ConcurrentModificationException. 
		Note that the output may differ in your system because HashMap keyset is not ordered like list. 
		If you will uncomment the statement where I am adding a new key-value in the HashMap, it will cause ConcurrentModificationException. */
         
		
        Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");
 
        Iterator<String> it1 = myMap.keySet().iterator();
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println("Map Value:"+myMap.get(key));
            if(key.equals("2")){
            	System.out.println("Im entered..");
                myMap.put("1","4");
                myMap.put("4", "4"); 
            }
        }
 
    }


	}


