package com.redstack.feedbackcrudcustomerlink.practice;

import java.util.List;

public class StreamPractice {

    record Employee(int id, String name, String role) {
    }

    private static final List<Employee> EMPLOYEES = List.of(
            new Employee(1, "Alice", "Developer"),
            new Employee(2, "Bob", "Designer"),
            new Employee(3, "Carol", "Developer"),
            new Employee(4, "Dave", "Manager"),
            new Employee(5, "Eve", "Tester"));

    private static final String TARGET_ROLE = "Developer";
    private static final String MISSING_ROLE = "Architect";

    public static void main(String[] args) {
        System.out.println("=== 1. filter(): employees with role " + TARGET_ROLE + " ===");
        EMPLOYEES.stream()
                .filter(employee -> TARGET_ROLE.equals(employee.role()))
                .forEach(System.out::println);

        System.out.println("\n=== 2. map(): all employee names ===");
        EMPLOYEES.stream()
                .map(Employee::name)
                .forEach(System.out::println);

        System.out.println("\n=== 3. filter() then map(): names of " + TARGET_ROLE + " employees ===");
        EMPLOYEES.stream()
                .filter(employee -> TARGET_ROLE.equals(employee.role()))
                .map(Employee::name)
                .forEach(System.out::println);

        System.out.println("\n=== 4. filter() then findFirst(): first employee by role ===");
        printFirstByRole(TARGET_ROLE);
        printFirstByRole(MISSING_ROLE);
    }

    private static void printFirstByRole(String role) {
        System.out.println("Role " + role + ": " + EMPLOYEES.stream()
                .filter(employee -> role.equals(employee.role()))
                .findFirst()
                .map(Employee::toString)
                .orElse("not found"));
    }
}
