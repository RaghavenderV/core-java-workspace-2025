//https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
package com.vodapally.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeOperationsUsingStream {

	public static void main(String[] args) {
		List<TSEmployee> list = TSEmployee.getEmployeeList();
		
		//1. How many male and female employees are there in the organization?
		Map<String, Long> genderCountMap = list.stream().collect(Collectors.groupingBy(TSEmployee::getGender, Collectors.counting()));
		System.out.println("Gender Count: "+genderCountMap);
		System.out.println("------------------------------");
		
		//2. Print the name of all departments in the organization?
		List<String> deptList = list.stream().map(TSEmployee::getDepartment).distinct().collect(Collectors.toList());
		System.out.println("Departments List: \n"+deptList);
		System.out.println("------------------------------");
		
		//3. What is the average age of male and female employees?
		Map<String, Double> averageAge = list.stream().collect(Collectors.groupingBy(TSEmployee::getGender, 
											Collectors.averagingInt(TSEmployee::getAge)));
		System.out.println("Average age: "+averageAge);
		
		System.out.println("------------------------------");
		
		//4. Get the details of highest paid employee in the organization?
		Optional<TSEmployee> highestPaidEmp = list.stream().collect(Collectors.maxBy(Comparator.comparingDouble(TSEmployee::getSalary)));
		 
		System.out.println("Highest Paid Employee : "+highestPaidEmp.get());
		System.out.println("------------------------------");
		
		//5. Sort by Employee Salary big to small
		System.out.println("Sort by Employee Salary Big to Small");
		List<TSEmployee> sortedEmployees = list.stream().sorted(Comparator.comparingDouble(TSEmployee::getSalary).reversed())
												.collect(Collectors.toList());
		sortedEmployees.forEach(System.out::println);
		System.out.println("------------------------------");
		
		//6. find 3rd highest salary
		System.out.println("Third Highest Salary: ");
		String sal = list.stream().sorted(Comparator.comparingDouble(TSEmployee::getSalary).reversed())
												.skip(2).limit(1).map(TSEmployee::getName).findFirst().get();
		System.out.println("3rd Highest Salary Employee Name : "+sal);
		System.out.println("------------------------------");
		
		//7.  Get the names of all employees who have joined after 2015?
		
		List<String> empList = list.stream().filter(emp -> emp.getYearOfJoining()>2015)
									.map(TSEmployee::getName).collect(Collectors.toList());
		
		System.out.println("Names of all employees who have joined after 2015 : "+empList);
		System.out.println("------------------------------");
		
		//8. Count the number of employees in each department?
		Map<String, Long> count = list.stream().collect(Collectors.groupingBy(TSEmployee::getDepartment, Collectors.counting()));
		System.out.println("Count the number of employees in each department: \n"+count);
		System.out.println("------------------------------");
		
		//9. Get the details of youngest male employee in the product development department?
		TSEmployee emp = list.stream().filter(e -> (e.getDepartment().equals("Product Development")) && 
						(e.getGender().equals("Male")))
						.min(Comparator.comparingInt(TSEmployee::getAge))
						.get();
		
		System.out.println("\nDetails of YOUNGEST MALE employee in the product development department\n"+emp);
		System.out.println("------------------------------");
		
		//10. What is the average salary and total salary of the whole organization?
		//For this query, we use Collectors.summarizingDouble() on Employee::getSalary 
		//which will return statistics of the employee salary like max, min, average and total.
		System.out.println("\nWhat is the average salary and total salary of the whole organization");
		DoubleSummaryStatistics empSalaryStats = list.stream().collect(Collectors.summarizingDouble(TSEmployee::getSalary));
		System.out.println("Average Salary = "+empSalaryStats.getAverage());
		System.out.println("Total Salary = "+empSalaryStats.getSum());
		System.out.println("Min Salary = "+empSalaryStats.getMin());
		System.out.println("------------------------------\n");
		
		//11. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		//Use -> Collectors.partitioningBy()
		
		Set<Entry<Boolean,List<TSEmployee>>> set = list.stream().collect(Collectors.partitioningBy(e-> e.getAge()>25)).entrySet();
		for (Entry<Boolean, List<TSEmployee>> entry : set) 
		{
		    System.out.println("----------------------------");
		    if (entry.getKey()) {
		        System.out.println("Employees older than 25 years :");
		    }
		    else {
		        System.out.println("Employees younger than or equal to 25 years :");
		    }
		             
		    System.out.println("----------------------------");
		             
		    List<TSEmployee> ageList = entry.getValue();
		             
		    for (TSEmployee e : ageList) {
		        System.out.println(e.getName());
		    }
		}
		
	}

}

class TSEmployee {
	private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	private double salary;

	public static List<TSEmployee> getEmployeeList() {
		List<TSEmployee> employeeList = new ArrayList<TSEmployee>();

		employeeList.add(new TSEmployee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new TSEmployee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new TSEmployee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new TSEmployee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new TSEmployee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new TSEmployee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new TSEmployee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new TSEmployee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new TSEmployee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new TSEmployee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new TSEmployee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new TSEmployee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new TSEmployee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new TSEmployee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new TSEmployee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new TSEmployee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new TSEmployee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		return employeeList;
	}

	public TSEmployee() {
	}

	public TSEmployee(int id, String name, int age, String gender, String department, int yearOfJoining,
			double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "TSEmployee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

}
