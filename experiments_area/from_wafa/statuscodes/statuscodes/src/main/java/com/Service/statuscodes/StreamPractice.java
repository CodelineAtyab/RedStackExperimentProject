package com.Service.statuscodes;

import com.Service.statuscodes.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Sara", "Developer"));
        employees.add(new Employee("2", "Ali", "Developer"));
        employees.add(new Employee("3", "Noor", "Tester"));

        // Task 1 filter only items matching condition
        System.out.println("--- Task 1: Developers ---");
        List<Employee> developers = employees.stream().filter((currEmployee) -> {
            return "Developer".equals(currEmployee.getRole());
        }).collect(Collectors.toList());
        developers.forEach(currEmployee -> System.out.println(currEmployee.getName()));

        // Task 2 map items to one of their fields
        System.out.println("--- Task 2: All names ---");
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        // Task 3  filter then map
        System.out.println("--- Task 3: Developer names ---");
        List<String> developerNames = employees.stream()
                .filter(currEmployee -> "Developer".equals(currEmployee.getRole()))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(developerNames);

        // Task 4 filter and findFirst
        System.out.println("--- Task 4: Find by id ---");
        Employee foundTwo = employees.stream()
                .filter(currEmployee -> "2".equals(currEmployee.getId()))
                .findFirst()
                .orElse(null);
        if (foundTwo != null) {
            System.out.println(foundTwo.getName());
        } else {
            System.out.println("not found");
        }

        Employee foundNinetyNine = employees.stream()
                .filter(currEmployee -> "99".equals(currEmployee.getId()))
                .findFirst()
                .orElse(null);
        if (foundNinetyNine != null) {
            System.out.println(foundNinetyNine.getName());
        } else {
            System.out.println("not found");
        }
    }
}