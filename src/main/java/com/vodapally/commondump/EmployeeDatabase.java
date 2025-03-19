package com.vodapally.commondump;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeDatabase {
    public static List<Employee> fetchEmployees() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("src/main/resources/employees.json"),
                    new TypeReference<List<Employee>>() {
                    });
        } catch (IOException e) {
            System.out.println("Due to : " + e);
        }
        return null;
    }
}
