package com.redstack.servicelayerpart2.practice;

import com.redstack.servicelayerpart2.model.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("1", "Sara", "Developer"));
        employees.add(new Employee("2", "Ali", "Developer"));
        employees.add(new Employee("3", "Noor", "Designer"));

        // Task 1: Filter developers
        System.out.println("--- Task 1: Developers ---");

        employees.stream()
                .filter(employee -> employee.getRole().equals("Developer"))
                .forEach(employee -> System.out.println(employee.getName()));


        // Task 2: Map employees to names
        System.out.println("--- Task 2: Employee names ---");

        ArrayList<String> employeeNames = employees.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(employeeNames);


        // Task 3: Filter and map
        System.out.println("--- Task 3: Developer names ---");

        ArrayList<String> developerNames = employees.stream()
                .filter(employee -> employee.getRole().equals("Developer"))
                .map(employee -> employee.getName())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(developerNames);


        // Task 4: Filter and findFirst
        System.out.println("--- Task 4: Find employee by ID ---");

        String searchId = "2";

        Employee foundEmployee = employees.stream()
                .filter(employee -> employee.getId().equals(searchId))
                .findFirst()
                .orElse(null);

        if (foundEmployee != null) {
            System.out.println(foundEmployee.getName());
        } else {
            System.out.println("Employee " + searchId + " not found");
        }

        String missingId = "99";

        Employee missingEmployee = employees.stream()
                .filter(employee -> employee.getId().equals(missingId))
                .findFirst()
                .orElse(null);

        if (missingEmployee != null) {
            System.out.println(missingEmployee.getName());
        } else {
            System.out.println("Employee " + missingId + " not found");
        }
    }
}
