package com.vodapally.designpatterns;

import java.util.ArrayList;
import java.util.List;

class Employees implements Cloneable{
	private List<String> empList;
	
	public Employees() {
		empList = new ArrayList<String>();
	}
	
	public Employees(List<String> empList){
		this.empList = empList;
	}
	
	public void loadData(){
		empList.add("Raghu");
		empList.add("Abhi");
		empList.add("Sai");
		empList.add("Varun");
	}

	public List<String> getEmpList() {
		return empList;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<String>();
		for(String s : this.getEmpList()){
			tempList.add(s);
		}
		return new Employees(tempList);
	}
}

public class PrototypeDesignPattern {
	public static void main(String[] args)throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		
		// use the clone method to get the Employees object
		Employees empsNew1 = (Employees)emps.clone();
		Employees empsNew2 = (Employees)emps.clone();
		
		List<String> list1 = empsNew1.getEmpList();
		list1.add("Ravi");
		
		List<String> list2 = empsNew2.getEmpList();
		list2.remove("Sai");
		
		System.out.println("emps List : "+emps.getEmpList());
		System.out.println("empsNew1 list : "+list1);
		System.out.println("empsNew2 list : "+list2);
		
		
	}

}

/*
 * Prototype pattern is one of the Creational Design pattern, so it provides a mechanism of 
 * object creation. Prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already existing. 
 * So this pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs. This pattern uses java cloning to copy the object.

It would be easy to understand this pattern with an example, suppose we have an Object that 
loads data from database. Now we need to modify this data in our program multiple times, 
so its not a good idea to create the Object using new keyword and load all the data again from database. So the better approach is to clone the existing object into a new object and then do the data manipulation.

Prototype design pattern mandates that the Object which you are copying should provide the 
copying feature. It should not be done by any other class. However whether to use shallow or deep copy of the Object properties depends on the requirements and its a design decision.

Simply, The prototype pattern is a creational design pattern. In the prototype pattern, a new object is created by cloning an existing object.
*/
