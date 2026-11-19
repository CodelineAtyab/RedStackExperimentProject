package org.example;

import java.util.List;
import java.util.Optional;

public class StreamPractice {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("1", "Sara", "Developer"),
                new Employee("2", "Ali", "Developer"),
                new Employee("3", "Noor", "QA Engineer")
        );

        System.out.println("--- Task 1: employees with role Developer ---");
        List<Employee> developers = employees.stream()
                .filter(e -> "Developer".equals(e.role()))
                .toList();
        System.out.println(developers);

        System.out.println("--- Task 2: all employee names ---");
        List<String> allNames = employees.stream()
                .map(Employee::name)
                .toList();
        System.out.println(allNames);

        System.out.println("--- Task 3: developer names ---");
        List<String> developerNames = employees.stream()
                .filter(e -> "Developer".equals(e.role()))
                .map(Employee::name)
                .toList();
        System.out.println(developerNames);

        System.out.println("--- Task 4: find employee by id ---");
        printEmployeeById(employees, "2");
        printEmployeeById(employees, "99");
    }

    private static void printEmployeeById(List<Employee> employees, String targetId) {
        Optional<Employee> match = employees.stream()
                .filter(e -> e.id().equals(targetId))
                .findFirst();

        if (match.isPresent()) {
            System.out.println("id " + targetId + " -> " + match.get());
        } else {
            System.out.println("id " + targetId + " -> not found");
        }
    }
}