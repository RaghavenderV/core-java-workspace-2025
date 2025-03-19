package com.vodapally.threads;

import com.vodapally.commondump.Employee;
import com.vodapally.commondump.EmployeeDatabase;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CombineCompletableFuture {
    public CompletableFuture<Employee> getEmployeeDetails() {
        return CompletableFuture.supplyAsync(() -> EmployeeDatabase.fetchEmployees().stream()
                .filter(employee -> "85-939-9584".equals(employee.getEmployeeId()))
                .findAny().orElse(null));
    }

    public CompletableFuture<Integer> getRatings(Employee employee) {
        return CompletableFuture.supplyAsync(employee::getRating);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CombineCompletableFuture future = new CombineCompletableFuture();

        //combine two dependent futures using thenCompose()
        //first finds the employee with the id, then finds its rating
        CompletableFuture<Integer> thenComposeResults = future.getEmployeeDetails().thenCompose(future::getRatings);
        System.out.println("Employee id:85-939-9584, Rating: " + thenComposeResults.get()); //Ratings: 4

        //combine two independent futures using thenCombine()
        // task-1: group employees by gender and its count
        // task-2: get all emails
        // then combine -- independent tasks
        CompletableFuture<Map<String, Long>> employeeMapFuture = CompletableFuture.supplyAsync(() ->
                EmployeeDatabase.fetchEmployees().stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));

        CompletableFuture<List<String>> emailsFuture = CompletableFuture.supplyAsync(() ->
                EmployeeDatabase.fetchEmployees().stream()
                        .map(Employee::getEmail)
                        .collect(Collectors.toList()));

        CompletableFuture<String> thenCombineResult = employeeMapFuture.thenCombine(emailsFuture,
                (empMap, emails) ->
                        empMap + " " + emails);

        System.out.println(thenCombineResult.get());
    }
}
