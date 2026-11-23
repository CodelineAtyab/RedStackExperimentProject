package com.redstack.EmployeesApi.practice;

import java.util.List;

public class StreamPractice {

    public static void main(String[] args) {
        List<PracticeEmployee> employees = List.of(
                new PracticeEmployee("1", "Sara", "Developer"),
                new PracticeEmployee("2", "Ali", "Developer"),
                new PracticeEmployee("3", "Noor", "Designer")
        );

        System.out.println("--- Task 1: developers ---");
        employees.stream()
                .filter(employee -> employee.role.equals("Developer"))
                .forEach(System.out::println);

        System.out.println("--- Task 2: all employee names ---");
        List<String> names = employees.stream()
                .map(employee -> employee.name)
                .toList();
        System.out.println(names);

        System.out.println("--- Task 3: developer names ---");
        List<String> developerNames = employees.stream()
                .filter(employee -> employee.role.equals("Developer"))
                .map(employee -> employee.name)
                .toList();
        System.out.println(developerNames);

        System.out.println("--- Task 4: find employee by ID ---");
        employees.stream()
                .filter(employee -> employee.id.equals("2"))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Employee not found"));

        employees.stream()
                .filter(employee -> employee.id.equals("99"))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Employee 99 not found"));
    }

    private static class PracticeEmployee {
        private final String id;
        private final String name;
        private final String role;

        private PracticeEmployee(String id, String name, String role) {
            this.id = id;
            this.name = name;
            this.role = role;
        }

        @Override
        public String toString() {
            return "Employee{id='" + id + "', name='" + name
                    + "', role='" + role + "'}";
        }
    }
}