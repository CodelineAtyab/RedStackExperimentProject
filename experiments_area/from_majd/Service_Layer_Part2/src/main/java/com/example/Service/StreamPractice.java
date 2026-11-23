
package com.example.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {

        ArrayList<EmployeePractice> employees = new ArrayList<>();

        employees.add(new EmployeePractice("1", "Sara", "Developer"));
        employees.add(new EmployeePractice("2", "Ali", "Developer"));
        employees.add(new EmployeePractice("3", "Noor", "Designer"));

        // Task 1: Filter employees whose role is Developer
        System.out.println("--- Task 1: Developers ---");

        employees.stream()
                .filter(employee -> employee.role.equals("Developer"))
                .forEach(employee -> System.out.println(employee.name));


        // Task 2: Map employees to their names
        System.out.println("--- Task 2: Employee Names ---");

        ArrayList<String> names = employees.stream()
                .map(employee -> employee.name)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(names);


        // Task 3: Filter developers and map them to their names
        System.out.println("--- Task 3: Developer Names ---");

        ArrayList<String> developerNames = employees.stream()
                .filter(employee -> employee.role.equals("Developer"))
                .map(employee -> employee.name)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(developerNames);


        // Task 4: Filter and find the first employee by ID
        System.out.println("--- Task 4: Find Employee ---");

        Optional<EmployeePractice> employee = employees.stream()
                .filter(e -> e.id.equals("2"))
                .findFirst();

        System.out.println(employee.map(e -> e.name).orElse("not found"));

        Optional<EmployeePractice> missingEmployee = employees.stream()
                .filter(e -> e.id.equals("99"))
                .findFirst();

        System.out.println(missingEmployee.map(e -> e.name).orElse("not found"));
    }
}
