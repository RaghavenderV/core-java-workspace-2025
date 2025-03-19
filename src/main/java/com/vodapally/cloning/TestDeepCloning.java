package com.vodapally.cloning;

import lombok.AllArgsConstructor;
import lombok.Data;

// Deep cloning  involves creating a copy of the object along with copies of the objects referenced by its fields.
// This ensures that changes to the cloned object do not affect the original object. To achieve deep copying,
// you need to override the clone() method and clone the referenced objects as well
@Data
@AllArgsConstructor
class Department implements Cloneable{
    int id;
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@Data
@AllArgsConstructor
class Employee implements Cloneable{
    int empId;
    String empName;
    Department department;

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Employee clonedEmployee = (Employee) super.clone();
        clonedEmployee.department = (Department) department.clone();

        return clonedEmployee;
    }

}
public class TestDeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Department hrDept = new Department(101,"Human Resources");
        Employee origianlEmployee = new Employee(501,"Haneesh",hrDept);
        Employee clonedEmployee = (Employee) origianlEmployee.clone();

        System.out.println("Original Employee --> "+origianlEmployee);

        // let's change the dept name
        clonedEmployee.department.name = "Information Technology";

        System.out.println("origianlEmployee.department.name : "+origianlEmployee.department.name); //Human Resources
        System.out.println("clonedEmployee.department.name : "+clonedEmployee.department.name); // Information Technology
    }
}
