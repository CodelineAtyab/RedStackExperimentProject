package com.redstack.employees;

import java.util.List;

public class StreamPractice {

    record PracticeEmployee(String id, String name, String role) {}

    public static void main(String[] args) {

        // CREATE SAMPLE EMPLOYEES
        List<PracticeEmployee> employees = List.of(
                new PracticeEmployee("1", "Sara", "Developer"),
                new PracticeEmployee("2", "Ali", "Developer"),
                new PracticeEmployee("3", "Noor", "Designer")
        );

        // ========================================
        // TASK 1: FILTER
        // ========================================

        System.out.println("--- Task 1: Developers ---");

        List<PracticeEmployee> developers = employees.stream()
                .filter(employee -> employee.role().equals("Developer"))
                .toList();

        developers.forEach(employee ->
                System.out.println(employee.name())
        );

        // ========================================
        // TASK 2: MAP
        // ========================================

        System.out.println("--- Task 2: All Names ---");

        List<String> names = employees.stream()
                .map(PracticeEmployee::name)
                .toList();

        System.out.println(names);

        // ========================================
        // TASK 3: FILTER THEN MAP
        // ========================================

        System.out.println("--- Task 3: Developer Names ---");

        List<String> developerNames = employees.stream()
                .filter(employee -> employee.role().equals("Developer"))
                .map(PracticeEmployee::name)
                .toList();

        System.out.println(developerNames);

        // ========================================
        // TASK 4: FILTER + FINDFIRST
        // ========================================

        System.out.println("--- Task 4: Find Employee ---");

        String foundEmployee = employees.stream()
                .filter(employee -> employee.id().equals("2"))
                .findFirst()
                .map(PracticeEmployee::name)
                .orElse("not found");

        System.out.println("Employee with ID 2: " + foundEmployee);

        String missingEmployee = employees.stream()
                .filter(employee -> employee.id().equals("99"))
                .findFirst()
                .map(PracticeEmployee::name)
                .orElse("not found");

        System.out.println("Employee with ID 99: " + missingEmployee);
    }
}