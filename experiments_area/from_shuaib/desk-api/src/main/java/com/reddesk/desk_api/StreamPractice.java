package com.reddesk.desk_api;

import com.reddesk.desk_api.models.Employee;

import java.util.List;
import java.util.Optional;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("1", "Sara", "Developer"),
                new Employee("2", "Ali", "Developer"),
                new Employee("3", "Noor", "Designer")
        );

        System.out.println("--- developers ---");
        List<Employee> developers = employees.stream()
                .filter(e -> "Developer".equals(e.getRole()))
                .toList();
        developers.forEach(e -> System.out.println(e.getName()));

        System.out.println("--- all names ---");
        List<String> names = employees.stream()
                .map(Employee::getName)
                .toList();
        System.out.println(names);

        System.out.println("--- developer names ---");
        List<String> devNames = employees.stream()
                .filter(e -> "Developer".equals(e.getRole()))
                .map(Employee::getName)
                .toList();
        System.out.println(devNames);

        System.out.println("--- find by id ---");
        printEmployeeById(employees, "2");
        printEmployeeById(employees, "99");
    }

    private static void printEmployeeById(List<Employee> employees, String id) {
        Optional<Employee> match = employees.stream()
                .filter(e -> id.equals(e.getId()))
                .findFirst();
        System.out.println(match.map(Employee::getName).orElse("not found"));
    }
}