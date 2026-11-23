package com.noor.employeesapi;

import com.noor.employeesapi.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Noor", "IT"));
        employees.add(new Employee(2, "Sara", "Developer"));
        employees.add(new Employee(3, "Ali", "Developer"));


        System.out.println("--- Task 1: Developers ---");

        employees.stream()
                .filter(e -> e.getDepartment().equals("Developer"))
                .forEach(e -> System.out.println(e.getName()));


        System.out.println("--- Task 2: Employee Names ---");

        List<String> names = employees.stream()
                .map(e -> e.getName())
                .toList();

        System.out.println(names);


    System.out.println("--- Task 3: Developer Names ---");

    List<String> developerNames = employees.stream()
            .filter(e -> e.getDepartment().equals("Developer"))
            .map(e -> e.getName())
            .toList();

System.out.println(developerNames);

        System.out.println("--- Task 4: Find Employee ---");

        employees.stream()
                .filter(e -> e.getId() == 2)
                .findFirst()
                .ifPresentOrElse(
                        e -> System.out.println("Found: " + e.getName()),
                        () -> System.out.println("Employee not found")
                );

        employees.stream()
                .filter(e -> e.getId() == 99)
                .findFirst()
                .ifPresentOrElse(
                        e -> System.out.println("Found: " + e.getName()),
                        () -> System.out.println("Employee not found")
                );

}}