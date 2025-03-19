package com.vodapally.solid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Employee {
    String name;
}

class EmployeeRepository {
    void saveToDatabase(Employee emp) {
        System.out.println("Saved in Database.." + emp.name);
    }
}

class EmployeeReport {
    void printReport(Employee emp) {
        System.out.println("Print the report: " + emp.name);
    }
}

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Employee employee = new Employee("Chatrapathi");

        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.saveToDatabase(employee);

        EmployeeReport empReport = new EmployeeReport();
        empReport.printReport(employee);
    }
}
