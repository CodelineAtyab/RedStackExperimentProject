package com.teamred.employees;

import java.util.ArrayList;
import java.util.List;

public class StreamPractice {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Mohammed", "Developer"));
        employees.add(new Employee("2", "Ali", "Developer"));
        employees.add(new Employee("3", "Omar", "Tester"));


        System.out.println("--- Task 1: developers ---");
        List<Employee> developers = employees.stream()
                .filter(e -> e.getRole().equals("Developer"))
                .toList();
        developers.forEach(e -> System.out.println(e.getName() + " (" + e.getRole() + ")"));


        System.out.println("--- Task 2: all names ---");
        List<String> names = employees.stream()
                .map(Employee::getName)
                .toList();
        System.out.println(names);


        System.out.println("--- Task 3: developer names ---");
        List<String> developerNames = employees.stream()
                .filter(e -> e.getRole().equals("Developer"))
                .map(Employee::getName)
                .toList();
        System.out.println(developerNames);


        System.out.println("--- Task 4: find by id ---");
        printById(employees, "2");
        printById(employees, "99");
    }

    private static void printById(List<Employee> employees, String id) {
        employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        e -> System.out.println("id " + id + " -> " + e.getName()),
                        () -> System.out.println("id " + id + " -> not found"));
    }
}