package com.vodapally.cloning;
/*
* Author@ Raghavender Vodapally
* Date@ Jul 3, 2018
*/
//best example
//https://dzone.com/articles/shallow-and-deep-java-cloning
class Person implements Cloneable{
	private String name;
	private int income;
	private City city;
	
	@Override
	protected Person clone() throws CloneNotSupportedException {
		
		return (Person) super.clone();
	}

	public Person(String name, int income, City city) {
		this.name = name;
		this.income = income;
		this.city = city;
	}

	//equals and hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + income;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (income != other.income)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Person1 [name=" + name + ", income=" + income + ", city=" + city + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}

class City {
	private String name;
	
	public City(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "City1 [name=" + name + "]";
	}

	//equals and hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
public class ShallowCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		City city = new City("Hyderabad");
		Person person1 = new Person("Raghavender",50154,city);
		
		System.out.println("Person1");
		System.out.println(person1);
		System.out.println("-------------------------------------------");
		
		System.out.println("Person2 - cloned object");
		Person person2 = person1.clone();
		
		System.out.println(person2);
		System.out.println("-------------------------------------------");
		
		if(person1 == person2) {
			System.out.println("Both person1 and person2 holds the same object");
		}
		
		if(person1.equals(person2)) {
			System.out.println("Both person1 and person2 are equal and have the same content - person1.equals(person2)");
		}
		
		if(person1.getCity() == person2.getCity()) {
			System.out.println("Both person1 and person2 have same city object(referring to same object)");
		}
		
		//lets change city name using person2
		person2.setCity(new City("Bangalore"));
		
		System.out.println("After changing city name by person2 cloned object");
		System.out.println("Person1 city name : "+ person1.getCity());
		System.out.println("Person2 city name : "+ person2.getCity());
	}

}

