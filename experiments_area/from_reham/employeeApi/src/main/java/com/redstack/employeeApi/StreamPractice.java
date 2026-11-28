package com.redstack.employeeApi;

import java.util.ArrayList;
import java.util.List;

public class StreamPractice {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Sara"));
        employees.add(new Employee(2, "Ali"));
        employees.add(new Employee(3, "Noor"));

        System.out.println("--- Task 1: Filter ---");

        employees.stream()
                .filter(employee -> employee.getId() > 1)
                .forEach(employee -> System.out.println(employee.getName()));

        System.out.println("--- Task 2: Map ---");

        List<String> names = employees.stream()
                .map(Employee::getName)
                .toList();

        System.out.println(names);

        System.out.println("--- Task 3: Filter and Map ---");

        List<String> selectedNames = employees.stream()
                .filter(employee -> employee.getId() > 1)
                .map(Employee::getName)
                .toList();

        System.out.println(selectedNames);

        System.out.println("--- Task 4: Find First ---");

        employees.stream()
                .filter(employee -> employee.getId() == 2)
                .findFirst()
                .ifPresentOrElse(
                        employee -> System.out.println(employee.getName()),
                        () -> System.out.println("not found")
                );
    }
}