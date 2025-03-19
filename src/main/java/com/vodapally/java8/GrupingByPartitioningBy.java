package com.vodapally.java8;

import com.vodapally.common.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrupingByPartitioningBy {
    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee(101, "Raghavender", 820000L, "Admin"),
                new Employee(102, "Mallesh", 61000L, "Admin"),
                new Employee(103, "Srinivas", 59000L, "Admin"),
                new Employee(104, "Prashanth", 75000L, "Admin"),
                new Employee(105, "Anjali", 45000L, "Finance"),
                new Employee(106, "Anjali", 45000L, "Finance"), //Duplicate record
                new Employee(107, "Praveen", 60000L, "Human Resources"),
                new Employee(108, "Vihaan", 41000L, "Human Resources"),
                new Employee(109, "Anjali", 45000L, "Information Technology"),
                new Employee(110, "Sanvika", 12000L, "Information Technology"),
                new Employee(111, "Vedu", 33000L, "Information Technology"),
                new Employee(112, "Manjula", 63000L, "Sales"));

        // group employees by department
        Map<String, List<Employee>> groupByDeptMap = list.stream().collect(Collectors.groupingBy(Employee::getDept));

        // print the grouped employees
        groupByDeptMap.forEach((dept, employeeList) -> {
            System.out.println("Department : " + dept);
            employeeList.forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // group by department with unique employees(lets assume if name is same, consider employee as duplicate  )
        Map<String, Set<Employee>> uniqueEmployeesByDept = list.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.toSet()));
        System.out.println("\nUnique Employees By Department");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        uniqueEmployeesByDept.forEach((depmt, set) -> {
            System.out.println("Department : " + depmt);
            set.forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //-------------------------------------------------------------------------


        // group by department with unique employees and sort by group name(lets assume if name is same, consider employee as duplicate  )
        System.out.println("group by department with unique employees and sort by group name");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        LinkedHashMap<String, Set<Employee>> uniqueEmployeesSortedBySalary = list.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        LinkedHashMap::new,
                        Collectors.toSet()));
        uniqueEmployeesSortedBySalary.forEach((department, employeeSet) -> {
            System.out.println("Department : " + department);
            employeeSet.forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        });

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // segregate employees by salary >600000 and <600000
        System.out.println("\nSegregate employees by salary >600000 and <600000");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Map<Boolean, List<Employee>> partitionedBySalary = list.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 600000L));
        System.out.println("Employees with salary >600000");
        partitionedBySalary.get(true).forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Employees with salary <600000");
        partitionedBySalary.get(false).forEach(System.out::println);


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nlowest salary employee in each department\n");
        Map<String, Optional<Employee>> lowestSalaryEmployee = list.stream().collect(Collectors.groupingBy(
                Employee::getDept, Collectors.minBy(Comparator.comparing(Employee::getSalary))));

        lowestSalaryEmployee.forEach((dept, emp) -> {
            System.out.println(dept + ": " + emp.get());
        });


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("average salary in each department\n");
        Map<String, Double> avgSalary = list.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.averagingLong(Employee::getSalary)));
        avgSalary.forEach((dept, sal) -> {
            System.out.println(dept + ": " + sal);
        });



        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("find the second highest salary in all departments\n");

        Employee employee = list.stream().sorted(Comparator.comparing(Employee::getSalary))
                .skip(1).findFirst().get();
        System.out.println("second highest salary in all departments : " + employee.getSalary() + " and employee name is " + employee.getName());




        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~END~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("find the second highest salary in ech department\n");
        int n=1; // change n value for nth highest salary

        Map<String, Optional<Employee>> secondHighestEmpSalary = list.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(
                Collectors.toList(), employeeList -> employeeList.stream()
                                                            .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                                                            .skip(n)
                                                            .findFirst())));

        secondHighestEmpSalary.forEach((dept, emp) ->
                System.out.println("Department: " + dept + ": " + emp.orElse(null)));


    }
}

