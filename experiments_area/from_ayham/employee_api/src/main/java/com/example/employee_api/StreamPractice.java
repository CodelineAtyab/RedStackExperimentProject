// .\mvnw.cmd -DskipTests compile
// java -cp target\classes com.example.employee_api.StreamPractice

package com.example.employee_api;

import java.util.ArrayList;
import java.util.List;

public class StreamPractice {
    private record PracticeEmployee(String id, String name, String role) {
    }

    public static void main(String[] args) {
        List<PracticeEmployee> employees = new ArrayList<>(List.of(
                new PracticeEmployee("1", "Sara", "Developer"),
                new PracticeEmployee("2", "Ali", "Developer"),
                new PracticeEmployee("3", "Noor", "Designer")));

        System.out.println("--- Task 1: developers ---");
        employees.stream()
                .filter(employee -> employee.role().equals("Developer"))
                .forEach(employee -> System.out.println(employee.name()));

        System.out.println("--- Task 2: all employee names ---");
        List<String> names = employees.stream()
                .map(PracticeEmployee::name)
                .toList();
        System.out.println(names);

        System.out.println("--- Task 3: developer names ---");
        List<String> developerNames = employees.stream()
                .filter(employee -> employee.role().equals("Developer"))
                .map(PracticeEmployee::name)
                .toList();
        System.out.println(developerNames);

        System.out.println("--- Task 4: find employee by ID ---");
        System.out.println(findEmployeeName(employees, "2"));
        System.out.println(findEmployeeName(employees, "99"));
    }

    private static String findEmployeeName(List<PracticeEmployee> employees, String id) {
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .map(PracticeEmployee::name)
                .orElse("not found");
    }
}
