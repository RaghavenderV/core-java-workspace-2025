package com.vodapally.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/*
* Author@ Raghavender Vodapally
* Date@ Jan 22, 2018
*/
public class ConcurrentHashMapVSsynchronizedMap { // http://www.javainuse.com/java/javaConcurrentHashMap

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		// Map<String, Integer> myMap = Collections.synchronizedMap(map);

		Map<String, Integer> myMap = new ConcurrentHashMap<>(); // check with above code also

		MapHelper1 mapHelper1 = new MapHelper1(myMap);
		MapHelper2 mapHelper2 = new MapHelper2(myMap);
		MapHelper3 mapHelper3 = new MapHelper3(myMap);
		MapHelper4 mapHelper4 = new MapHelper4(myMap);

		for (Entry<String, Integer> e : myMap.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}

	}

}

class MapHelper1 implements Runnable {
	Map<String, Integer> map;

	public MapHelper1(Map<String, Integer> map) {
		this.map = map;

		new Thread(this, "MapHelper-1").start();
	}

	@Override
	public void run() {
		map.put("One", 1);

		try {
			System.out.println("MapHelper-1 is sleeping..");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class MapHelper2 implements Runnable {
	Map<String, Integer> map;

	public MapHelper2(Map<String, Integer> map) {
		this.map = map;

		new Thread(this, "MapHelper-2").start();
	}

	@Override
	public void run() {
		map.put("Two", 2);

		try {
			System.out.println("MapHelper-2 is sleeping..");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class MapHelper3 implements Runnable {
	Map<String, Integer> map;

	public MapHelper3(Map<String, Integer> map) {
		this.map = map;

		new Thread(this, "MapHelper-3").start();
	}

	@Override
	public void run() {
		map.put("Three", 3);

		try {
			System.out.println("MapHelper-3 is sleeping..");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class MapHelper4 implements Runnable {
	Map<String, Integer> map;

	public MapHelper4(Map<String, Integer> map) {
		this.map = map;

		new Thread(this, "MapHelper-4").start();
	}

	@Override
	public void run() {
		map.put("Four", 4);

		try {
			System.out.println("MapHelper-4 is sleeping..");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
