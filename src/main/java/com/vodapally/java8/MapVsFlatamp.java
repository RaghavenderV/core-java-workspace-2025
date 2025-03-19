package com.vodapally.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Institute{
	String name;
	List<String> addressList;
	
	public Institute(String name, List<String> addressList) {
		this.name = name;
		this.addressList = addressList;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Institute [name=" + name + ", addressList=" + addressList + "]";
	}
	
	
}
public class MapVsFlatamp {

	public static void main(String[] args) {
		List<Institute> instituteList = new ArrayList<>();
		instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
		instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
		instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));
		
		//extract name of each Institute, that can be done using map()
		Set<String> namesOfInstitutes  = instituteList.stream().map(Institute::getName).collect(Collectors.toSet());
		namesOfInstitutes.forEach(System.out::println);
		
		//to extract unique locations of all institutes, using flatMap()
		System.out.println("\nName of Unique Locations: ");
		Set<String> nameOfLocations = instituteList.stream().flatMap(inst ->inst.getAddressList().stream()).collect(Collectors.toSet());
		nameOfLocations.forEach(System.out::println);

	}

}
