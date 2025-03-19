package com.vodapally.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//This class is used to load Employee class
public class StaticDatabase {
	
	public static List<Employee> loadEmployeeData(){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(101, "Raghavender", 820000L, "Information Technology"));
		list.add(new Employee(102, "Mallesh", 610000L, "Admin"));
		list.add(new Employee(103, "Srinivas", 590000L, "Human Resources"));
		list.add(new Employee(104, "Prashanth", 750000L, "Sales"));
		list.add(new Employee(105, "Anitha", 450000L, "Finance"));
		list.add(new Employee(106, "Haneesh", 990000L, "Information Technology"));
		
		return list;
	}
	
	public static Map<Integer, String> loadMapData(){
		Map<Integer, String> map = new HashMap<>();
        map.put(111, "Lisa");
        map.put(222, "Narayan");
        map.put(333, "Xiangh");
        map.put(444, "Arunkumar");
        map.put(555, "Jyous");
        map.put(666, "Haneesh");
        
		return map;
	}

}
