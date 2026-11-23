package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamPractice {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "Sara", "Developer"));
        employees.add(new Employee("2", "Ali", "Developer"));
        employees.add(new Employee("3", "Noor", "Designer"));


        System.out.println("--- Task 1: developers ---");
        List<Employee> developers = employees.stream()
                .filter(e -> e.getRole().equals("Developer"))
                .toList();
        for (Employee e : developers) {
            System.out.println(e.getName());
        }


        System.out.println("--- Task 2: all names ---");
        List<String> names = employees.stream()
                .map(e -> e.getName())
                .toList();
        System.out.println(names);


        System.out.println("--- Task 3: developer names ---");
        List<String> developerNames = employees.stream()
                .filter(e -> e.getRole().equals("Developer"))
                .map(e -> e.getName())
                .toList();
        System.out.println(developerNames);


        System.out.println("--- Task 4: find by id ---");
        printEmployeeWithId(employees, "2");
        printEmployeeWithId(employees, "99");
    }

    private static void printEmployeeWithId(List<Employee> employees, String id) {
        Optional<Employee> found = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        if (found.isPresent()) {
            System.out.println("id " + id + " -> " + found.get().getName());
        } else {
            System.out.println("id " + id + " -> not found");
        }
    }
}
